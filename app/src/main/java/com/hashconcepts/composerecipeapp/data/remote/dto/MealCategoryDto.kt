package com.hashconcepts.composerecipeapp.data.remote.dto

import androidx.annotation.Keep

@Keep
data class MealCategoryDto(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String
)