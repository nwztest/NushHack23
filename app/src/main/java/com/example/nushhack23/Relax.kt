package com.example.nushhack23

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun RelaxFragment() {
    Text(text = "Relax Test", modifier = Modifier.fillMaxSize(), color= Color.Green)
}

@Composable
fun DeepBreathingCard() {
    Surface() {
        Box() {
//           Image()
        }
    }
}