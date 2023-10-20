package com.example.composepractice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composepractice.screen.basics.GameScreen
import com.example.composepractice.screen.layouts.LayoutsBasicsScreen
import com.example.composepractice.screen.navigation.MyAppNavHost
import com.example.composepractice.screen.pagers.PagerScreen
import com.example.composepractice.screen.sideeffects.DisposableEffectScreen
import com.example.composepractice.screen.sideeffects.GreetingWithLaunchedEffect
import com.example.composepractice.screen.sideeffects.SideEffectsScreen
import com.example.composepractice.screen.state.viewmodel.GameScreenWithViewModel
import com.example.composepractice.screen.theming.Movies
import com.example.composepractice.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var name : String? = "Charlie"
        name = null
        Log.d("DEMO", "${name?.length}")

        setContent {
            ComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //LayoutsBasicsScreen()
                    //MyAppNavHost()
                    //Movies()
                    PagerScreen()
                }
            }
        }
    }
}

