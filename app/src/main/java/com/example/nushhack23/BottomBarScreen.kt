package com.example.nushhack23

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material.icons.outlined.Inventory2
import androidx.compose.material.icons.outlined.Lightbulb
import androidx.compose.material.icons.outlined.Spa
import androidx.compose.ui.graphics.vector.ImageVector


sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val filledIcon: ImageVector,
    val outlinedIcon: ImageVector
) {
    object Focus : BottomBarScreen(
        route = "focus",
        title = "Focus",
        filledIcon = Icons.Filled.Lightbulb,
        outlinedIcon = Icons.Outlined.Lightbulb
    )

    object Organise : BottomBarScreen(
        route = "organise",
        title = "Organise",
        filledIcon = Icons.Filled.Inventory2,
        outlinedIcon = Icons.Outlined.Inventory2
    )

    object Relax : BottomBarScreen(
        route = "relax",
        title = "Relax",
        filledIcon = Icons.Filled.Spa,
        outlinedIcon = Icons.Outlined.Spa
    )
}