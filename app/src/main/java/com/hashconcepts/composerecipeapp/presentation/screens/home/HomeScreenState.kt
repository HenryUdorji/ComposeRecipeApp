package com.hashconcepts.composerecipeapp.presentation.screens.home

import com.hashconcepts.composerecipeapp.data.remote.dto.category.CategoryDto
import com.hashconcepts.composerecipeapp.data.remote.dto.mealByCategory.MealDto
import com.hashconcepts.composerecipeapp.domain.models.Category
import com.hashconcepts.composerecipeapp.domain.models.MealCategory

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
    val mealsByCategory: List<MealCategory> = emptyList()
)
