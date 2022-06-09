package com.hashconcepts.composerecipeapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hashconcepts.composerecipeapp.ui.MainViewModel
import com.hashconcepts.composerecipeapp.ui.screens.home.HomeScreen
import com.hashconcepts.composerecipeapp.ui.screens.onboarding.OnBoardingScreen

/**
 * @created 06/06/2022 - 2:18 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */

@Composable
fun Navigation(
    navController: NavHostController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val startDestination =  if (!viewModel.showOnboarding) Screens.OnBoardingScreen.route else Screens.HomeScreen.route
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Screens.OnBoardingScreen.route) {
            OnBoardingScreen(navController = navController)
        }
        composable(Screens.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
    }
}
