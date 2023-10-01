package com.example.composepractice.screen.navigation.ui.about

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier,
    helpText: String = "Guessing game",
    userId: Int = 0
) {
    Text(text = "$helpText")
}