package com.hashconcepts.composerecipeapp.ui.screens.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.hashconcepts.composerecipeapp.ui.navigation.MainActions

/**
 * @created 12/06/2022 - 9:17 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */
@Composable
fun DetailScreen(
    navController: NavHostController,
    mealId: String
) {
    val viewModel = hiltViewModel<DetailViewModel>()
    val detailScreenState = viewModel.detailScreenState.value

    LaunchedEffect(true) {
        viewModel.fetchMealDetail(mealId)
    }
}