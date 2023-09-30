package com.example.composepractice.screen.sideeffects

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext

//DisposableEffect is used to execute a side effect when the parent composable is first rendered
//and disposes of the effect when the Composable is removed from the UI hierarchy
//useful for managing resources that need to be cleaned up after the Composable is no longer in use
//Typically used when the composable leaves the screen

@Composable
fun DisposableEffectScreen(){
    var state by remember {
        mutableStateOf(true)
    }
    Column {
        Button(onClick = { state = !state }) {
            Text(text = "Change state")
        }
        if (state){
            DisposableEffectView()
        }
    }
    
}
@Composable
fun DisposableEffectView(){
    val context = LocalContext.current
    
    DisposableEffect(key1 = Unit ) {
        Toast.makeText(context, "Enter to composition", Toast.LENGTH_SHORT).show()
        
        onDispose {
            Toast.makeText(context, "Leave composition", Toast.LENGTH_SHORT).show()
        }
    }
    
    Column {
        Text(text = "Content")
    }
    
}