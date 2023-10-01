package com.example.composepractice.screen.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
    startDestination: String = "mainmenuscreen"
) {
    NavHost(
        navController = navController,
        startDestination = startDestination ) {

        composable("mainmenuscreen") {
            MainMenuScreen(
                onNavigateToGame = {navController.navigate("gamescreen?upperBound=20")},
                onNavigateToHelp = {navController.navigate("helpscreen")},
                onNavigateToAbout = {navController.navigate("aboutscreen")}
            )
        }

        composable("gamescreen?upperBound={upperBound}") {
            GameScreenWithNavigation()
        }

        composable("helpscreen") {
            HelpScreen()
        }
        composable("aboutscreen") {
            AboutScreen()
        }
    }
}