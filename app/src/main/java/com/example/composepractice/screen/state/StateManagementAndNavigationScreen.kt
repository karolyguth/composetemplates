package com.example.composepractice.screen.state

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import java.util.Date

@Composable
fun ShowTimeScreen(){
    var dateTime by rememberSaveable {
        mutableStateOf("")
    }
    ShowTime(dateTime, onChange = {
        dateTime = Date(System.currentTimeMillis()).toString()
    })

}

//STATE HOISTING:
//Here we create a stateless composable as we make it so that
//dateTime is passed as a parameter
//the other parameter onChange is a method
//onChange:() -> Unit basically means that the ShowTime expects a lambda method to be passed
//the lambda passed to onChange is then called from the button's onClick and executes
//the passed method
@Composable
fun ShowTime(dateTime: String, onChange:() -> Unit){
    Column {
        Text(text = "$dateTime")
        Button(onClick = { onChange }) {
            Text(text = "Show time")
        }
    }
}