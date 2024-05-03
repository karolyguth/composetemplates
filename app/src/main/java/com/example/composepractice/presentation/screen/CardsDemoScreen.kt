package com.example.composepractice.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composepractice.presentation.components.cards.CardWithArchedSeparator
import com.example.composepractice.presentation.components.cards.createDummyData
import com.example.composepractice.presentation.ui.LocalSpacing

@Composable
fun CardsDemoScreen() {
    val spacing = LocalSpacing.current
    val dummyItems = createDummyData()

    Box(modifier = Modifier.fillMaxSize()) {
        val items = createDummyData()
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),  // Adjust the number of columns as needed
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(items.size) { index ->
                val item = items[index]
                CardWithArchedSeparator(
                    width = item.width.dp,
                    height = item.height.dp,
                    imagePainterResource = item.imageResource,
                    onClick = { item.onClick },
                    title = item.title,
                    subtitle = item.subtitle
                )
            }
        }
    }
}