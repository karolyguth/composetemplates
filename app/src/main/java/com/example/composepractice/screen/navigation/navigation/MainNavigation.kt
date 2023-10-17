package com.example.composepractice.screen.navigation.navigation

sealed class MainNavigation(val route: String) {
    object MainScreen: MainNavigation("mainscreen")
    object GamesScreen: MainNavigation("gamescreen"){
        fun createRoute(upperBound: Int) = "gamescreen?upperBound={$upperBound}"
    }
    object AboutScreen: MainNavigation("aboutscreen")
    object HelpScreen: MainNavigation("helpscreen")
}