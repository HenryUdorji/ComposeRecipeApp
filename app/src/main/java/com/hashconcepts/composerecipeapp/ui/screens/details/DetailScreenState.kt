package com.hashconcepts.composerecipeapp.ui.screens.details

import com.hashconcepts.composerecipeapp.data.remote.dto.details.Meal

/**
 * @created 12/06/2022 - 11:01 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */
data class DetailScreenState(
    val isLoading: Boolean = false,
    val error: String = "",
    val mealDetail: Meal? = null,
)
