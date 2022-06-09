package com.hashconcepts.composerecipeapp.data.remote

import com.hashconcepts.composerecipeapp.data.remote.dto.category.MealCategoriesDto
import com.hashconcepts.composerecipeapp.data.remote.dto.details.MealDetailsDto
import com.hashconcepts.composerecipeapp.data.remote.dto.mealByCategory.MealByCategoryDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @created 09/06/2022 - 9:44 AM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */
interface MealApi {

    @GET("lookup.php")
    suspend fun fetchMealDetail(@Query("i") id: Int): MealDetailsDto

    @GET("categories.php")
    suspend fun fetchMealCategories(): MealCategoriesDto

    @GET("filter.php")
    suspend fun filterMealsByCategory(@Query("c") category: String): MealByCategoryDto
}