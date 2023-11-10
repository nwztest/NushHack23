package com.example.nushhack23

import CupShuffleGame1
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.nushhack23.FocusFragment
import com.example.nushhack23.OrganisationFragment
import com.example.nushhack23.RelaxFragment
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
                ReactionGame()
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
        composable(route = BottomBarScreen.Relax.route) {
            RelaxFragment()
        }
    }
}