package com.hashconcepts.composerecipeapp.domain.repository

import com.hashconcepts.composerecipeapp.data.remote.dto.category.MealCategoriesDto
import com.hashconcepts.composerecipeapp.data.remote.dto.details.MealDetailsDto
import com.hashconcepts.composerecipeapp.data.remote.dto.mealByCategory.MealByCategoryDto

/**
 * @created 09/06/2022 - 10:47 AM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */
interface MealsRepository {
    suspend fun fetchMealCategories(): MealCategoriesDto
    suspend fun fetchMealDetails(id: String): MealDetailsDto
    suspend fun filterMealByCategory(category: String): MealByCategoryDto
}