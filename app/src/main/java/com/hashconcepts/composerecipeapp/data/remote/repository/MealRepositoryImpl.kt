package com.hashconcepts.composerecipeapp.data.remote.repository

import com.hashconcepts.composerecipeapp.data.remote.MealApi
import com.hashconcepts.composerecipeapp.data.remote.dto.category.MealCategoriesDto
import com.hashconcepts.composerecipeapp.data.remote.dto.details.MealDetailsDto
import com.hashconcepts.composerecipeapp.data.remote.dto.mealByCategory.MealByCategoryDto
import javax.inject.Inject

/**
 * @created 09/06/2022 - 10:52 AM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */
class MealRepositoryImpl @Inject constructor(
    private val mealApi: MealApi
): MealsRepository {
    override suspend fun fetchMealCategories(): MealCategoriesDto {
        return mealApi.fetchMealCategories()
    }

    override suspend fun fetchMealDetails(id: Int): MealDetailsDto {
        return mealApi.fetchMealDetail(id)
    }

    override suspend fun filterMealByCategory(category: String): MealByCategoryDto {
        return mealApi.filterMealsByCategory(category)
    }

}