package com.example.nushhack23

import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.foundation.lazy.items
import androidx.navigation.NavController

data class ChatActivity(val name: String, val description: String, val id: Int)
val chatActivities = listOf(
    ChatActivity("Grounding", "Utilise the 54321 Technique", R.drawable.grounded),
    ChatActivity("Jokes", "Have some fun, lighten up", R.drawable.laugh),
    ChatActivity("Chat", "Just a normal chat session", R.drawable.chat)
)

@Composable
fun RelaxFragment(navController: NavController) {
    Column() {
        DeepBreathingCard(navController)
        Spacer(modifier = Modifier.size(20.dp))
        Text("Chatbot", fontSize = 28.sp, modifier=Modifier.padding(10.dp))
        LazyRelax()
    }
}

@Composable
fun DeepBreathingCard(navController: NavController) {
    Surface(shadowElevation = 20.dp,
        modifier = Modifier
            .padding(10.dp)
            .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(30.dp))
            .clip(RoundedCornerShape(30.dp))
            .clickable { navController.navigate("deep_breathing") }
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
fun ChatCard(chatActivity: ChatActivity) {
    Surface(color=Color.Yellow, modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(10.dp))
        .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(10.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Icon(
                painter = painterResource(id = chatActivity.id),
                contentDescription = "Image for ${chatActivity.name}",
                modifier = Modifier
                    .size(100.dp, 100.dp)
                    .align(Alignment.CenterVertically)
            )
            Column(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterVertically)) {
                Text(chatActivity.name, fontSize = 48.sp)
                Text(chatActivity.description, fontSize = 24.sp, modifier = Modifier.fillMaxWidth())
            }
        }
    }
}

@Composable
fun LazyRelax() {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(4.dp), contentPadding = PaddingValues(10.dp, 10.dp)) {
        items(chatActivities) {chatActivity ->
            ChatCard(ChatActivity(chatActivity.name, chatActivity.description, chatActivity.id))
        }
    }
}



@Preview
@Composable
fun preview1() {
    LazyRelax()
}