package com.vini.playground.navigation

sealed class ScreenRoutes(val route: String) {
    object HomeScreen : ScreenRoutes("home_screen")
    object CardItauScreen : ScreenRoutes("card_itau_screen")
    object LoginLotusScreen : ScreenRoutes("login_lotus_screen")
}
