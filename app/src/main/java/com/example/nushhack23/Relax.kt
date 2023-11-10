package com.example.nushhack23

import android.content.Intent
import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun RelaxFragment() {
    Text(text = "Relax Test", modifier = Modifier.fillMaxSize(), color= Color.Green)
}

@Composable
fun DeepBreathingCard() {
    Surface(shadowElevation = 20.dp,
        modifier = Modifier
            .border(BorderStroke(2.dp, Color.Black), RoundedCornerShape(30.dp))
            .clip(RoundedCornerShape(30.dp))
    ) {
        Box() {
           Image(
               painter = painterResource(id = R.drawable.breathing_exercise_for_teens_and_tweens),
               contentDescription = "Woman breathing",
//               modifier = Modifier.matchParentSize()
           )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Deep breathing", fontSize=36.sp)
                Text(text = "Relax your mind", fontSize=20.sp)
            }
        }
    }
}



@Composable
fun ChatCard(imageVector: ImageVector) {
    Column() {
        Icon(imageVector = imageVector, contentDescription = "Image of type of talking")
        Text("")
    }
}



@Preview
@Composable
fun preview1() {
    DeepBreathingCard()
}