package com.example.composepractice.screen.drawer.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composepractice.screen.drawer.AboutScreen
import com.example.composepractice.screen.drawer.DrawerHomeScreen
import com.example.composepractice.screen.drawer.SettingsScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerNavHost(
    drawerState: DrawerState,
    navController: NavHostController = rememberNavController(),
    startDestination: String = DrawerNavigation.DrawerScreen.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(DrawerNavigation.DrawerScreen.route) {
            DrawerHomeScreen(drawerState)
        }
        composable(DrawerNavigation.AboutScreen.route) {
            AboutScreen()
        }
        composable(DrawerNavigation.SettingsScreen.route) {
            SettingsScreen()
        }
    }
}