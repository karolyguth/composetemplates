package com.example.composepractice.screen.navigation.viewmodels.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class GameScreenWithNavigationViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    var generatedNum by mutableStateOf(0)
    var upperBound by mutableStateOf(3)
    var counter by mutableStateOf(0)
    init {
        savedStateHandle.get<Int>("upperBound")?.let {
            upperBound = it
        }
        generateNum()
    }

    fun generateNum() {
        generatedNum = Random(System.currentTimeMillis()).nextInt(upperBound)
    }

    fun increaseCounter() {
        counter++
    }
}