package com.hashconcepts.composerecipeapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hashconcepts.composerecipeapp.ui.screens.onboarding.OnBoardingViewModel
import com.hashconcepts.composerecipeapp.ui.screens.home.HomeScreen
import com.hashconcepts.composerecipeapp.ui.screens.home.ViewMoreScreen
import com.hashconcepts.composerecipeapp.ui.screens.onboarding.OnBoardingScreen
import com.hashconcepts.composerecipeapp.util.Constants
import com.hashconcepts.composerecipeapp.util.Constants.ARGS_CATEGORY

/**
 * @created 06/06/2022 - 2:18 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */

@Composable
fun Navigation(
    viewModel: OnBoardingViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    val actions = remember(navController) { MainActions(navController) }

    val startDestination =  if (!viewModel.showOnboarding) {
        Screens.OnBoardingScreen.route
    } else {
        Screens.HomeScreen.route
    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Screens.OnBoardingScreen.route) {
            OnBoardingScreen(actions)
        }
        composable(Screens.HomeScreen.route) {
            HomeScreen(actions)
        }
        composable(
            route = Screens.ViewMoreScreen.route + "/{$ARGS_CATEGORY}",
            arguments = listOf(
                navArgument(Constants.ARGS_CATEGORY) {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            val category = entry.arguments?.getString(Constants.ARGS_CATEGORY).toString()
            ViewMoreScreen(actions, category)
        }
    }
}

class MainActions(private val navController: NavHostController) {

    val popBackStack: () -> Unit = {
        navController.popBackStack()
    }

    val gotoOnBoardingScreen: () -> Unit = {
        navController.popBackStack()
        navController.navigate(Screens.OnBoardingScreen.route)
    }

    val gotoHomeScreen: () -> Unit = {
        navController.popBackStack()
        navController.navigate(Screens.HomeScreen.route)
    }

    val gotoDetailsScreen: () -> Unit = {
        navController.navigate(Screens.DetailScreen.route)
    }

    val gotoViewMoreScreen: (String) -> Unit = { category ->
        navController.navigate(Screens.ViewMoreScreen.withArgs(category))
    }
}
