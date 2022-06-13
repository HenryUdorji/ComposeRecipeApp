package com.hashconcepts.composerecipeapp.domain.usecases

import com.hashconcepts.composerecipeapp.domain.repository.MealsRepository
import com.hashconcepts.composerecipeapp.data.remote.dto.category.MealCategoriesDto
import com.hashconcepts.composerecipeapp.data.remote.dto.category.toCategory
import com.hashconcepts.composerecipeapp.domain.models.Category
import com.hashconcepts.composerecipeapp.domain.models.MealCategory
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
class FetchMealCategoriesUseCase @Inject constructor(
    private val repository: MealsRepository
) {
    operator fun invoke(): Flow<Resource<List<Category>>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.fetchMealCategories().categories.map { it.toCategory() }
            emit(Resource.Success(response))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}