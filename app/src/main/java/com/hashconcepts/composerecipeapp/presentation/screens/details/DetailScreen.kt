package com.hashconcepts.composerecipeapp.presentation.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
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

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(OffWhite)
    ) {

    }
}