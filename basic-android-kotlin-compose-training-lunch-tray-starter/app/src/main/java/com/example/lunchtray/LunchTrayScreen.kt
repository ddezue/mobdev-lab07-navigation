package com.example.lunchtray

import androidx.annotation.StringRes

enum class LunchTrayScreen(@param:StringRes val title: Int, val route: String) {
    Start(title = R.string.app_name, route = "Start"),
    Entree(title = R.string.choose_entree, route = "Entree"),
    SideDish(title = R.string.choose_side_dish, route = "SideDish"),
    Accompaniment(title = R.string.choose_accompaniment, route = "Accompaniment"),
    Checkout(title = R.string.order_checkout, route = "Checkout")
}