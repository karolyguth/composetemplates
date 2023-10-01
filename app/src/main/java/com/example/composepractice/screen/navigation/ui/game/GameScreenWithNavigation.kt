package com.example.composepractice.screen.navigation.ui.game

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composepractice.screen.navigation.viewmodels.game.GameScreenWithNavigationViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreenWithNavigation(
    //viewModel() is the standard way how a composable can have a viewModel
    //this helper will make sure that the assigned class is instantiated properly
    //!viewModel() is a helper function!
    //!viewModel() comes from the androidx.compose:navigation-compose library
    gameScreenViewModel: GameScreenWithNavigationViewModel = viewModel()
) {
    Column {
        var randomNumber = gameScreenViewModel.generatedNum

        var numberText by rememberSaveable {
            mutableStateOf("")
        }
        var textResult by rememberSaveable {
            mutableStateOf("")
        }
        var inputErrorState by rememberSaveable {
            mutableStateOf(false)
        }
        var showWinDialog by rememberSaveable {
            mutableStateOf(false)
        }

        fun validate(text: String){
            val allDigit = text.all { char -> char.isDigit() }

            inputErrorState = !allDigit && text != ""
            if (inputErrorState){
                textResult = "This field can be number only"
            }
        }
        OutlinedTextField(
            label = { Text(text = "Enter your guess here") },
            value = "$numberText",
            onValueChange = {
                numberText = it
                validate(numberText)
            },
            isError = inputErrorState,
            trailingIcon = {
                if (inputErrorState)
                    Icon(
                        Icons.Filled.Warning,
                        "error", tint = MaterialTheme.colorScheme.error)
            }
        )
        Button(onClick = {
            try {
                gameScreenViewModel.increaseCounter()

                val myNumber = numberText.toInt()
                if(myNumber == randomNumber) {
                    textResult = "You won"
                    gameScreenViewModel.generateNum()
                    gameScreenViewModel.counter = 0
                    showWinDialog = true
                } else {
                    textResult = "You lose"
                }
            } catch (e: Exception) {
                textResult = "Error: ${e.message}"
            }
        }) {
            Text(text = "Guess (${gameScreenViewModel.counter})")
        }
        Text(text = "$textResult", fontSize = 28.sp)

        SimpleAlertDialog(
            show = showWinDialog,
            onDismiss = {showWinDialog = false},
            onConfirm = {showWinDialog = false}
        )

        Button(onClick = {
            gameScreenViewModel.generateNum()
            gameScreenViewModel.counter = 0
            numberText = ""
        }) {
            Text(text = "Restart")
        }
    }
}

@Composable
fun SimpleAlertDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if(show) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text(text = "Congratulations!") },
            text = { Text(text = "You have won") },
            confirmButton = {
                TextButton(onClick = onConfirm)
                { Text(text = "Ok") }
            },
            dismissButton = {
                TextButton(onClick = onDismiss)
                { Text(text = "Cancel") }
            }

        )
    }
}