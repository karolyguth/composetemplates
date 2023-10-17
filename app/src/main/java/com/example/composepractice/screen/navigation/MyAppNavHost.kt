package com.example.composepractice.screen.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composepractice.screen.navigation.navigation.MainNavigation
import com.example.composepractice.screen.navigation.ui.about.AboutScreen
import com.example.composepractice.screen.navigation.ui.game.GameScreenWithNavigation
import com.example.composepractice.screen.navigation.ui.help.HelpScreen
import com.example.composepractice.screen.navigation.ui.mainmenu.MainMenuScreen
import com.example.composepractice.screen.state.viewmodel.GameScreenWithViewModel
import kotlin.math.log

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = MainNavigation.MainScreen.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination ) {

        composable(MainNavigation.MainScreen.route) {
            MainMenuScreen(
                onNavigateToGame = {navController.navigate(MainNavigation.GamesScreen.createRoute(20))},
                onNavigateToHelp = {navController.navigate(MainNavigation.HelpScreen.route)},
                onNavigateToAbout = {navController.navigate(MainNavigation.AboutScreen.route)}
            )
        }

        composable(MainNavigation.GamesScreen.route) {
            GameScreenWithNavigation()
        }

        composable(MainNavigation.HelpScreen.route) {
            HelpScreen()
        }
        composable(MainNavigation.AboutScreen.route) {
            AboutScreen()
        }
    }
}