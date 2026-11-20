
package com.example.mycity

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mycity.ui.theme.MyCityTheme

// ЦВЕТА ПРИЛОЖЕНИЯ

private val White = Color(0xFFFFFFFF)
private val Black = Color(0xFF202020)
private val Gray = Color(0xFF777777)
private val LightGray = Color(0xFFEAEAEA)
private val PhotoBackground = Color(0xFFF4F4F4)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyCityTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = White
                ) {
                    MyCityApp()
                }
            }
        }
    }
}

// ГЛАВНОЕ ПРИЛОЖЕНИЕ

@Composable
fun MyCityApp(
    viewModel: MyCityViewModel = viewModel()
) {

    val navController = rememberNavController()

    // Получаем актуальные данные из ViewModel
    val places by viewModel.allPlaces.collectAsState()

    val categories = viewModel.categories

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {

        val isExpanded = maxWidth >= 840.dp

        if (isExpanded) {


            Row(
                modifier = Modifier.fillMaxSize()
            ) {

                Box(
                    modifier = Modifier
                        .weight(0.9f)
                        .fillMaxHeight()
                ) {

                    CategoryList(
                        categories = categories,
                        places = places,
                        onCategoryClick = { category ->

                            navController.navigate(
                                "category/${Uri.encode(category)}"
                            ) {
                                launchSingleTop = true
                            }
                        }
                    )
                }

                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .fillMaxHeight()
                        .background(LightGray)
                )

                Box(
                    modifier = Modifier
                        .weight(1.6f)
                        .fillMaxHeight()
                ) {

                    NavHost(
                        navController = navController,
                        startDestination = "empty"
                    ) {

                        composable("empty") {
                            EmptyDetailsPane()
                        }

                        composable(
                            route = "category/{categoryName}",
                            arguments = listOf(
                                navArgument("categoryName") {
                                    type = NavType.StringType
                                }
                            )
                        ) { entry ->

                            val categoryName =
                                entry.arguments?.getString("categoryName") ?: ""

                            PlaceListScreen(
                                category = categoryName,
                                places = places.filter {
                                    it.category == categoryName
                                },
                                showBackButton = false
                            )
                        }
                    }
                }
            }

        } else {


            NavHost(
                navController = navController,
                startDestination = "home"
            ) {

                composable("home") {

                    CategoryList(
                        categories = categories,
                        places = places,
                        onCategoryClick = { category ->

                            navController.navigate(
                                "category/${Uri.encode(category)}"
                            ) {
                                launchSingleTop = true
                            }
                        }
                    )
                }

                composable(
                    route = "category/{categoryName}",
                    arguments = listOf(
                        navArgument("categoryName") {
                            type = NavType.StringType
                        }
                    )
                ) { entry ->

                    val categoryName =
                        entry.arguments?.getString("categoryName") ?: ""

                    PlaceListScreen(
                        category = categoryName,
                        places = places.filter {
                            it.category == categoryName
                        },
                        showBackButton = true,
                        onBackClick = {
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryList(
    categories: List<String>,
    places: List<Place>,
    onCategoryClick: (String) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 36.dp,
                    bottom = 26.dp
                )
        ) {

            Text(
                text = "MY CITY",
                fontSize = 12.sp,
                letterSpacing = 2.sp,
                fontWeight = FontWeight.Medium,
                color = Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Откройте Кемерово",
                fontSize = 30.sp,
                lineHeight = 37.sp,
                fontWeight = FontWeight.Bold,
                color = Black
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Интересные места для прогулок, отдыха и встреч.",
                fontSize = 15.sp,
                lineHeight = 23.sp,
                color = Gray
            )
        }

        HorizontalDivider(
            color = LightGray,
            thickness = 1.dp
        )

        Text(
            text = "КАТЕГОРИИ",
            modifier = Modifier.padding(
                start = 24.dp,
                top = 25.dp,
                bottom = 15.dp
            ),
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 1.5.sp,
            color = Gray
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                start = 20.dp,
                end = 20.dp,
                bottom = 30.dp
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(
                items = categories,
                key = { it }
            ) { category ->

                val count = places.count {
                    it.category == category
                }

                CategoryCard(
                    category = category,
                    count = count,
                    onClick = {
                        onCategoryClick(category)
                    }
                )
            }
        }
    }
}

@Composable
fun CategoryCard(
    category: String,
    count: Int,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        border = BorderStroke(
            1.dp,
            LightGray
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 20.dp,
                    vertical = 23.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = category,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Black
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "${placesCountText(count)} в подборке",
                    fontSize = 13.sp,
                    color = Gray
                )
            }

            Text(
                text = "Открыть",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Gray
            )
        }
    }
}

@Composable
fun PlaceListScreen(
    category: String,
    places: List<Place>,
    showBackButton: Boolean,
    onBackClick: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {

        if (showBackButton) {

            // Заголовок с кнопкой назад
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 8.dp,
                        top = 10.dp,
                        bottom = 10.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = onBackClick
                ) {

                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Назад",
                        tint = Black
                    )
                }

                Text(
                    text = category,
                    fontSize = 21.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Black
                )
            }

        } else {

            Text(
                text = category,
                modifier = Modifier.padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 32.dp,
                    bottom = 16.dp
                ),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Black
            )
        }

        Text(
            text = "${placesCountText(places.size)} в этой категории",
            modifier = Modifier.padding(
                start = 24.dp,
                end = 24.dp,
                bottom = 18.dp
            ),
            fontSize = 14.sp,
            color = Gray
        )

        HorizontalDivider(
            color = LightGray,
            thickness = 1.dp
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                horizontal = 18.dp,
                vertical = 18.dp
            ),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {

            items(
                items = places,
                key = { it.id }
            ) { place ->

                PlaceCard(
                    place = place
                )
            }
        }
    }
}

@Composable
fun PlaceCard(
    place: Place
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        border = BorderStroke(
            1.dp,
            LightGray
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (place.imageRes == android.R.drawable.ic_menu_gallery) {

                Box(
                    modifier = Modifier
                        .size(105.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(PhotoBackground),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "ФОТО",
                        fontSize = 10.sp,
                        letterSpacing = 1.sp,
                        color = Gray
                    )
                }

            } else {

                Image(
                    painter = painterResource(
                        id = place.imageRes
                    ),
                    contentDescription = place.name,
                    modifier = Modifier
                        .size(105.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.width(15.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = place.name,
                    fontSize = 17.sp,
                    lineHeight = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Black
                )

                Spacer(modifier = Modifier.height(7.dp))

                Text(
                    text = place.description,
                    fontSize = 13.sp,
                    lineHeight = 19.sp,
                    color = Gray,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )

                if (place.address.isNotBlank()) {

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = place.address,
                        fontSize = 12.sp,
                        lineHeight = 17.sp,
                        color = Color(0xFF999999),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

@Composable
fun EmptyDetailsPane() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Выберите категорию",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = Black
            )

            Spacer(modifier = Modifier.height(9.dp))

            Text(
                text = "Здесь появятся интересные места Кемерова",
                fontSize = 14.sp,
                color = Gray
            )
        }
    }
}

fun placesCountText(count: Int): String {

    return when {

        count % 10 == 1 && count % 100 != 11 ->
            "$count место"

        count % 10 in 2..4 &&
                count % 100 !in 12..14 ->
            "$count места"

        else ->
            "$count мест"
    }
}
