package com.example.composepractice.screen.navigation.ui.help

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HelpScreen(
    modifier: Modifier = Modifier,
    helpText: String = "Use the app properly",
) {
    Text(text = "$helpText")
}