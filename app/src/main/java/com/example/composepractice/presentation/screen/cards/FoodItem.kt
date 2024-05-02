package com.example.composepractice.presentation.screen.cards

import androidx.compose.runtime.Composable
import com.example.composepractice.R

// Data class to hold the properties
data class FoodItem(
    val width: Int,
    val height: Int,
    val imageResource: Int,
    val onClick: @Composable (() -> Unit),
    val title: String,
    val subtitle: String
)

// Sample usage with dummy data
fun createDummyData(): List<FoodItem> {
    val dummyItems = listOf(
        FoodItem(
            width = 180,
            height = 140,
            imageResource = R.drawable.spaghetti,
            onClick = { /*TODO: Implement click behavior*/ },
            title = "Classic Spaghetti Bolognese",
            subtitle = "Calories: 560"
        ),
        FoodItem(
            width = 180,
            height = 140,
            imageResource = R.drawable.fruitbowl,
            onClick = { /*TODO: Implement click behavior*/ },
            title = "Fresh Fruit Bowl",
            subtitle = "Calories: 200"
        ),
        FoodItem(
            width = 180,
            height = 140,
            imageResource = R.drawable.pancakes,
            onClick = { /*TODO: Implement click behavior*/ },
            title = "Stack of Pancakes with Syrup",
            subtitle = "Calories: 520"
        )
    )
    return dummyItems
}
