package com.example.composepractice.screen.theming

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MoviceCard(movie: Movie, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ){
            Column(
                modifier = Modifier.padding(16.dp)
            ){
                Image(painter = painterResource(
                    id = movie.imageResourceId),
                    contentDescription = null,)
            }
    }

}

data class Movie(
    val title: String,
    val director: String,
    val releaseYear: Int,
    val description: String,
    val imageResourceId: Int
)