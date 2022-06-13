package com.hashconcepts.composerecipeapp.domain.usecases

import com.hashconcepts.composerecipeapp.data.remote.dto.mealByCategory.MealByCategoryDto
import com.hashconcepts.composerecipeapp.data.remote.dto.mealByCategory.toMealCategory
import com.hashconcepts.composerecipeapp.domain.models.MealCategory
import com.hashconcepts.composerecipeapp.domain.repository.MealsRepository
import com.hashconcepts.composerecipeapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * @created 09/06/2022 - 10:44 AM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */
class FilterMealsByCategoryUseCase @Inject constructor(
    private val repository: MealsRepository
) {
    operator fun invoke(category: String): Flow<Resource<List<MealCategory>>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.filterMealByCategory(category).meals.map { it.toMealCategory() }
            emit(Resource.Success(response))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}