package com.example.nushhack23

import android.graphics.LinearGradient
import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

fun operation(x: Int) : Int {
    return (x + 1) % 3
}
@Composable
fun DeepBreathingFragment(navController: NavHostController) {
    val infiniteTransient = rememberInfiniteTransition(label = "")
    val instructions = listOf(
        "Breathe in...",
        "Hold.",
        "Breathe out..."
    )
    var instructionIndex by remember { mutableIntStateOf(0) }
    LaunchedEffect(true) {
        // Coroutine to change the integer every 4, 5, and 6 seconds
        for (i in 0..9) {
            // Change the integer every 4 seconds
            delay(4000)
            instructionIndex = operation(instructionIndex)
            // Change the integer every 5 seconds
            delay(7000)
            instructionIndex = operation(instructionIndex)
            // Change the integer every 6 seconds
            delay(8000)
            instructionIndex = operation(instructionIndex)
        }
    }

    val zoomTransition = infiniteTransient.animateFloat(
        initialValue = .3f,
        targetValue = .3f,
        animationSpec = infiniteRepeatable(
            animation = keyframes{
                durationMillis = 19000
                .3f at 0 with EaseIn
                1f at 4000 with EaseIn
                1f at 11000 with EaseIn
                .3f at 19000 with EaseIn
            },
            repeatMode = RepeatMode.Restart
        ),
        label = ""
    )

    val textTransition = infiniteTransient.animateFloat(
        initialValue = 0f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 19000
                0f at 0 with EaseIn
                1f at 500 with EaseIn
                1f at 3500 with EaseIn
                0f at 4000 with EaseIn
                1f at 4500 with EaseIn
                1f at 10500 with EaseIn
                0f at 11000 with EaseIn
                1f at 11500 with EaseIn
                1f at 18500 with EaseIn
                0f at 19000 with EaseIn
            },
            repeatMode = RepeatMode.Restart
        ), label = ""
    )


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier=Modifier.fillMaxSize()
    ) {
        Icon(
            imageVector = Icons.Filled.Circle,
            contentDescription = "Circle",
            modifier = Modifier
                .size(200.dp)
                .zoomScale(zoomTransition.value),
            tint = Color(214, 197, 84, 255)
        )
        Text(text = instructions[instructionIndex], modifier=Modifier.alpha(textTransition.value))
    }


}

fun Modifier.zoomScale(scale: Float): Modifier = then(
    Modifier.graphicsLayer(
        scaleX = scale,
        scaleY = scale
    )
)