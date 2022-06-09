package com.hashconcepts.composerecipeapp.data.remote

import com.hashconcepts.composerecipeapp.data.remote.dto.CategoryDto
import com.hashconcepts.composerecipeapp.data.remote.dto.MealCategoryDto
import com.hashconcepts.composerecipeapp.data.remote.dto.MealDetailDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @created 09/06/2022 - 9:44 AM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */
interface MealApi {

    @GET("lookup.php")
    suspend fun fetchMealDetail(@Query("i") i: Int): List<MealDetailDto>

    @GET("categories.php")
    suspend fun fetchMealCategories(): List<CategoryDto>

    @GET("filter.php")
    suspend fun filterMealsByCategory(@Query("c") c: String): List<MealCategoryDto>
}