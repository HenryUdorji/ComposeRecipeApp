package com.hashconcepts.composerecipeapp.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hashconcepts.composerecipeapp.ui.screens.details.DetailScreen
import com.hashconcepts.composerecipeapp.ui.screens.home.HomeScreen
import com.hashconcepts.composerecipeapp.ui.screens.home.ViewMoreScreen
import com.hashconcepts.composerecipeapp.ui.screens.onboarding.OnBoardingScreen
import com.hashconcepts.composerecipeapp.ui.screens.splash.SplashScreen
import com.hashconcepts.composerecipeapp.util.Constants.ARGS_CATEGORY
import com.hashconcepts.composerecipeapp.util.Constants.ARGS_MEAL_ID

/**
 * @created 06/06/2022 - 2:18 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val actions = remember(navController) { MainActions(navController) }

    NavHost(navController = navController, startDestination = Screens.SplashScreen.route) {
        composable(Screens.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(Screens.OnBoardingScreen.route) {
            OnBoardingScreen(actions)
        }
        composable(Screens.HomeScreen.route) {
            HomeScreen(actions)
        }
        composable(
            route = Screens.ViewMoreScreen.route + "/{$ARGS_CATEGORY}",
            arguments = listOf(
                navArgument(ARGS_CATEGORY) {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            val category = entry.arguments?.getString(ARGS_CATEGORY).toString()
            ViewMoreScreen(actions, category)
        }
        composable(
            route = Screens.DetailScreen.route + "/{$ARGS_MEAL_ID}",
            arguments = listOf(
                navArgument(ARGS_MEAL_ID) {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            val mealId = entry.arguments?.getString(ARGS_MEAL_ID).toString()
            DetailScreen(actions, mealId)
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

    val gotoDetailsScreen: (String) -> Unit = { mealId ->
        navController.navigate(Screens.DetailScreen.withArgs(mealId))
    }

    val gotoViewMoreScreen: (String) -> Unit = { category ->
        navController.navigate(Screens.ViewMoreScreen.withArgs(category))
    }
}
