
package com.example.mycity

import androidx.annotation.DrawableRes

data class Place(
    val id: Int,
    val name: String,
    val description: String,
    val category: String,
    @DrawableRes val imageRes: Int = android.R.drawable.ic_menu_gallery,
    val address: String = ""
)
