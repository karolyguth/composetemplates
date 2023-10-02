package com.example.composepractice.screen.layouts.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColumnWeightDemo() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .border(width = 1.dp, color = Color.Blue),
        verticalArrangement = Arrangement.SpaceEvenly
        ) {
        Text(
            text = "Forrest Gump",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
        )
        Text(
            text = "1994",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
        )
        Text(
            text = "Movie",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
        )

    }
}