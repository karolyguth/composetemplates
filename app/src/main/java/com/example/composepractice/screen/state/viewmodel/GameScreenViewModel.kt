package com.example.composepractice.screen.state.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class GameScreenViewModel(): ViewModel() {

    var generatedNum by mutableStateOf(0)
    var upperBound by mutableStateOf(3)
    var counter by mutableStateOf(0)
    init {
        generateNum()
    }

    fun generateNum() {
        generatedNum = Random(System.currentTimeMillis()).nextInt(upperBound)
    }

    fun increaseCounter() {
        counter++
    }
}