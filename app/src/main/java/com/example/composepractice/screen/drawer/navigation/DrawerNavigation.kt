package com.example.composepractice.screen.drawer.navigation

sealed class DrawerNavigation(val route: String) {
    object DrawerScreen : DrawerNavigation("drawerhomescreen")
    object AboutScreen : DrawerNavigation("aboutscreen")
    object SettingsScreen : DrawerNavigation("settingsscreen")
}