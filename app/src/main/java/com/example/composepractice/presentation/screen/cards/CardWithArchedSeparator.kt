package com.example.composepractice.presentation.screen.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.composepractice.presentation.screen.cards.shapes.BottomArchedCutOffRectangleShape
import com.example.presentation.ui.LocalSpacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardWithArchedSeparator(
    width: Dp,
    height: Dp,
    color: Color = MaterialTheme.colorScheme.primary,
    title: String = "Title",
    subtitle: String = "Subtitle",
    imagePainterResource: Int,
    onClick: () -> Unit,
    elevation: CardElevation = CardDefaults.cardElevation(
        defaultElevation = 4.dp
    )
) {
    val spacing = LocalSpacing.current

    ElevatedCard(onClick = onClick, elevation = elevation) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .size(width, height)
                    .clip(
                        shape = BottomArchedCutOffRectangleShape
                    )
                    .background(color)
            ) {
                Image(
                    painter = painterResource(imagePainterResource),
                    contentDescription = "Image with arched bottom cutoff",
                    contentScale = ContentScale.FillHeight
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .height(spacing.spaceExtraLarge)
                    .width(width)
                    .padding(start = spacing.spaceMedium, end = spacing.spaceMedium)
            ) {
                Text(text = title,textAlign = TextAlign.Center, maxLines = 2, style = MaterialTheme.typography.bodyMedium, overflow = TextOverflow.Ellipsis)
                Text(text = subtitle,textAlign = TextAlign.Center,style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(bottom = spacing.spaceSmall), color = Color.Gray)
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2, showSystemUi = true)
@Composable
fun CardWithArchedSeparatorPreview() {
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


