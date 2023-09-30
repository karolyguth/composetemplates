package com.example.composepractice.screen.sideeffects

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext

@Composable
fun GreetingWithLaunchedEffect(){
    var state by remember { mutableStateOf(true) }
    val context = LocalContext.current

    //Launches stuff on the coroutine scope
    LaunchedEffect(key1 = state ) {
        Toast.makeText(context, "Hello", Toast.LENGTH_LONG).show()
    }
    
    Column {
        Button(
            onClick = { 
                state = !state
        }) {
            Text(text = "Press me")
        }
    }
}