package com.example.nushhack23

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun ReactionTimeGame() {
    var gameStarted by remember { mutableStateOf(false) }
    var startTime by remember { mutableStateOf(0L) }
    var reactionTime by remember { mutableStateOf(0L) }
    var averageTime by remember { mutableStateOf(0L) }
    var count by remember { mutableStateOf(0) }

    val backgroundColor = if (gameStarted) Color.Red else Color.Green

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(backgroundColor)
            .clickable {
                if (!gameStarted) {
                    gameStarted = true
                    startTime = System.currentTimeMillis() + Random.nextInt(1000, 4000)
                } else {
                    reactionTime = System.currentTimeMillis() - startTime
                    count++
                    averageTime = (averageTime * (count - 1) + reactionTime) / count
                    gameStarted = false
                }
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (!gameStarted) {
            Text("Click to start the game", color = Color.White)
        } else {
            Text("Reaction time: ${reactionTime}ms", color = Color.White)
            Text("Average reaction time: ${averageTime}ms", color = Color.White)
        }
    }
}
