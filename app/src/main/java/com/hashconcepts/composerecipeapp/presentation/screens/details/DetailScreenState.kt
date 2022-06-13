package com.hashconcepts.composerecipeapp.presentation.screens.details

import com.hashconcepts.composerecipeapp.data.remote.dto.details.MealDto
import com.hashconcepts.composerecipeapp.domain.models.MealDetail

/**
 * @created 12/06/2022 - 11:01 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */
data class DetailScreenState(
    val isLoading: Boolean = false,
    val error: String = "",
    val mealDetail: MealDetail? = null,
)
