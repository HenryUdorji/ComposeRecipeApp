package com.hashconcepts.composerecipeapp.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.hashconcepts.composerecipeapp.ui.MainViewModel

/**
 * @created 08/06/2022 - 2:09 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {

    viewModel.fetchMealCategories()
}