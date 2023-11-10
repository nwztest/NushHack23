package com.example.nushhack23

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FocusFragment() {
    Text(text = "Focus test", modifier = Modifier.fillMaxSize(), color= Color.Red)
}

@Preview
@Composable
fun previewFoc() {
    FocusFragment()
}