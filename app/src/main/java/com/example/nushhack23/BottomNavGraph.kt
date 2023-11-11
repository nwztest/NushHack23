package com.example.nushhack23

import CupShuffleGame1
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.nushhack23.FocusFragment
import com.example.nushhack23.OrganisationFragment
import com.example.nushhack23.RelaxFragment
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Focus.route
    ) {
        navigation(startDestination= "focus_hub", route = BottomBarScreen.Focus.route) {
            composable("focus_hub") {
                FocusFragment(navController)
            }
            composable("reaction_game") {
                ReactionTimeGame()
            }
            composable("cup_shuffle") {
                CupShuffleGame1(navController)
            }
            composable("card_match") {
                CardMatchGame()
            }
        }
        composable(route = BottomBarScreen.Organise.route) {
            OrganisationFragment()
        }
        navigation(route = BottomBarScreen.Relax.route, startDestination = "relax_hub") {
            composable("relax_hub"){
                RelaxFragment(navController = navController)
            }
            composable("chat") {}
            composable("deep_breathing") {
                DeepBreathingFragment(navController = navController)
            }
        }
    }
}