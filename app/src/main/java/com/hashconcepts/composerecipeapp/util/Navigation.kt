package com.hashconcepts.composerecipeapp.util

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hashconcepts.composerecipeapp.ui.screens.OnBoardingScreen

/**
 * @created 06/06/2022 - 2:18 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.OnBoardingScreen.route) {
        composable(Screens.OnBoardingScreen.route) {
            OnBoardingScreen(navController = navController)
        }
    }
}
