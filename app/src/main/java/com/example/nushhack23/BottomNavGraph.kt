package com.example.nushhack23

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.nushhack23.FocusFragment
import com.example.nushhack23.OrganisationFragment
import com.example.nushhack23.RelaxFragment
@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Focus.route
    ) {
        composable(route = BottomBarScreen.Focus.route) {
            FocusFragment()
        }
        composable(route = BottomBarScreen.Organise.route) {
            OrganisationFragment()
        }
        composable(route = BottomBarScreen.Relax.route) {
            RelaxFragment()
        }
    }
}