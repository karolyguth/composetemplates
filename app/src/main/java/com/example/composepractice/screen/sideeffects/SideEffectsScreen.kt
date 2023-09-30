package com.example.composepractice.screen.sideeffects

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import kotlin.math.log

@Composable
fun SideEffectsScreen(){
    var count by rememberSaveable { mutableStateOf(0) }



    Button(onClick = { count++ }) {
        Text("You have clicked $count times")
        //runs on recomposition
        SideEffect {
            Log.d("COUNT","count is $count")
        }
    }


}