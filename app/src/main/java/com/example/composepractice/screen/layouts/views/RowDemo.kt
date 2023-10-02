package com.example.composepractice.screen.layouts.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composepractice.R

@Composable
fun RowDemo() {
    Row (
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.forrest_gump),
            contentDescription = "Forrest Gump",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
        Column {
            Text(text = "Forrest Gump")
            Text(text = "1994")
        }
    }
}