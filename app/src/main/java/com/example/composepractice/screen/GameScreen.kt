package com.example.composepractice.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.composepractice.ui.theme.ComposePracticeTheme
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen() {
    Column {
        var randomNumber by rememberSaveable {
            mutableStateOf(Random(System.currentTimeMillis()).nextInt(3))
        }
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
            label = { Text(text = "Enter your guess here")},
            value = "$numberText",
            onValueChange = {
                numberText = it
                validate(numberText)
            },
            isError = inputErrorState,
            trailingIcon = {
                if (inputErrorState)
                    Icon(Icons.Filled.Warning,
                        "error", tint = MaterialTheme.colorScheme.error)
            }
            )
        Button(onClick = {
            try {
                val myNumber = numberText.toInt()
                if(myNumber == randomNumber) {
                    textResult = "You won"
                    showWinDialog = true
                } else {
                    textResult = "You lose"
                }
            } catch (e: Exception) {
                textResult = "Error: ${e.message}"
            }
        }) {
            Text(text = "Guess")
            
        }
        Text(text = "$textResult", fontSize = 28.sp)

        SimpleAlertDialog(
            show = showWinDialog,
            onDismiss = {showWinDialog = false},
            onConfirm = {showWinDialog = false}
        )
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




@Preview(showBackground = true)
@Composable
fun GreetingPreview(){
    ComposePracticeTheme {
        GameScreen()
    }
}