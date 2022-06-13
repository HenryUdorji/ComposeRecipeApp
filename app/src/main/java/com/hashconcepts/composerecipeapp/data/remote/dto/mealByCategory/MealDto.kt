package com.hashconcepts.composerecipeapp.data.remote.dto.mealByCategory

import com.hashconcepts.composerecipeapp.domain.models.MealCategory

data class MealDto(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String
)

fun MealDto.toMealCategory(): MealCategory {
    return MealCategory(idMeal, strMeal, strMealThumb)
}