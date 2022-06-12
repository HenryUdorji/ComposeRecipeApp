package com.hashconcepts.composerecipeapp.ui.screens.home

import com.hashconcepts.composerecipeapp.data.remote.dto.category.Category
import com.hashconcepts.composerecipeapp.data.remote.dto.mealByCategory.Meal

/**
 * @created 09/06/2022 - 5:18 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */
data class HomeScreenState(
    val isLoading: Boolean = false,
    val mealsLoading: Boolean = false,
    val error: String = "",
    val mealsError: String = "",
    val mealCategories: List<Category> = emptyList(),
    val mealByCategory: List<Meal> = emptyList()
)
