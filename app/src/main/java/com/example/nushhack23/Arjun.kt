import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.RestartAlt
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.nushhack23.BottomBarScreen
import com.example.nushhack23.BottomNavGraph
import com.example.nushhack23.R
import com.example.nushhack23.ui.theme.NushHack23Theme

@Composable
fun CupShuffleGame1(navController: NavHostController) {
    var cups by remember { mutableStateOf(generateCups()) }
    var shuffledCups by remember { mutableStateOf(cups.shuffled()) }
    var isGameStarted by remember { mutableStateOf(false) }
    var result by remember { mutableStateOf("") }
    var selectedCupIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Cup Shuffle Game",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.cup),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colors.primary)
                .clickable {
                    if (isGameStarted) {
                        result = if (selectedCupIndex == cups.indexOf(true)) {
                            "You Win!"
                        } else {
                            "You Lose! Try Again."
                        }
                        isGameStarted = false
                    } else {
                        shuffledCups = cups.shuffled()
                        isGameStarted = true
                        result = ""
                        selectedCupIndex = 0
                    }
                }
                .padding(16.dp)
        )

        if (isGameStarted) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                items(shuffledCups.size) { index ->
                    Cup(
                        index = index,
                        isSelected = index == selectedCupIndex,
                        onCupClick = {
                            selectedCupIndex = index
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = result,
            style = MaterialTheme.typography.h6,
            color = if (result == "You Win!") Color.Green else Color.Red
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(
                onClick = {
                    if (!isGameStarted) {
                        cups = generateCups()
                        shuffledCups = cups.shuffled()
                        result = ""
                        selectedCupIndex = 0
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.RestartAlt,
                    contentDescription = "Restart Game"
                )
            }

            IconButton(
                onClick = {
                    navController.navigate("focus_hub")
                }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }
        }
    }
}



@Composable
fun Cup(
    index: Int,
    isSelected: Boolean,
    onCupClick: () -> Unit
) {
    val cupSize = with(LocalDensity.current) { 60.dp.toPx() }

    Image(
        painter = painterResource(id = R.drawable.cup),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(if (isSelected) MaterialTheme.colors.primary else Color.Gray)
            .clickable {
                if (!isSelected) {
                    onCupClick()
                }
            }
            .padding(8.dp)
    )
}

fun generateCups(): List<Boolean> {
    return List(3) { it == 0 }
}

