package com.hashconcepts.composerecipeapp.ui.screens.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.hashconcepts.composerecipeapp.ui.theme.OffWhite

/**
 * @created 12/06/2022 - 9:17 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */
@Composable
fun DetailScreen(
    navController: NavHostController,
    systemUiController: SystemUiController,
    mealId: String
) {
    SideEffect {
        systemUiController.setNavigationBarColor(color = OffWhite)
        systemUiController.setStatusBarColor(color = OffWhite)
    }

    val viewModel = hiltViewModel<DetailViewModel>()
    val detailScreenState = viewModel.detailScreenState.value

    LaunchedEffect(true) {
        viewModel.fetchMealDetail(mealId)
    }
}