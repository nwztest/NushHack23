package com.example.nushhack23

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

data class FocusGame(val name: String, val description: String, val imageVector: ImageVector, val route: String)

val focusGames = listOf(
    FocusGame("Reaction Time", "How fast can you react?", Icons.Filled.Timer, "reaction_game"),
    FocusGame("Cup Shuffle", "How long can you keep your attention for?", Icons.Filled.Shuffle, "cup_shuffle"),
    FocusGame("Card Match", "Can you remember what is where?", Icons.Filled.Dashboard, "card_match"),
    )

@Composable
fun FocusFragment(navController: NavHostController) {
    Column() {
        focusGames.forEach { game ->
            GameCard(navController, game)
        }
    }
}

@Composable
fun GameCard(navController: NavHostController, focusGame: FocusGame) {
    Surface(
        color = Color(144, 202, 249, 255),
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate(focusGame.route)
            }
            .padding(10.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(10.dp)),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Icon(
                imageVector = focusGame.imageVector,
                contentDescription = "Image for ${focusGame.name}",
                modifier = Modifier
                    .size(100.dp, 100.dp)
                    .align(Alignment.CenterVertically)
            )
            Column(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterVertically)) {
                Text(focusGame.name, fontSize = 48.sp, lineHeight=56.sp)
                Text(focusGame.description, fontSize = 24.sp, modifier = Modifier.fillMaxWidth())
            }
        }
    }
}

@Composable
fun ReactionGame() {
    TODO("Not yet implemented")
}

@Composable
fun CupShuffleGame() {
    TODO("Not yet implemented")
}

@Composable
fun CardMatchGame() {
    TODO("Not yet implemented")
}

//@Preview
//@Composable
//fun previewFoc() {
//    FocusFragment()
//}