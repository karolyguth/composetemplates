package com.example.composepractice.screen.theming

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.composepractice.R

@Composable
fun Movies() {
    Column (modifier = Modifier.verticalScroll(rememberScrollState())) {
        MovieCard(
            movie = Movie(
            title = "Forest Gump",
            director = "Robert Zemeckis",
            releaseYear = 1994,
            description = "Forrest Gump is a 1994 American epic comedy-drama film directed by Robert Zemeckis and written by Eric Roth.",
            imageResourceId = R.drawable.forrest_gump
            )
        )
        MovieCard(
            movie = Movie(
                title = "Running",
                director = "Robert Zemeckis",
                releaseYear = 1994,
                description = "Forrest Gump is a 1994 American epic comedy-drama film directed by Robert Zemeckis and written by Eric Roth.",
                imageResourceId = R.drawable.running
            )
        )
    }
}