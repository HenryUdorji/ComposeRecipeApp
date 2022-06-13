package com.hashconcepts.composerecipeapp.domain.usecases

import com.hashconcepts.composerecipeapp.data.remote.dto.details.MealDetailsDto
import com.hashconcepts.composerecipeapp.data.remote.dto.details.toMeal
import com.hashconcepts.composerecipeapp.domain.models.MealDetail
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
class FetchMealDetailsUseCase @Inject constructor(
    private val repository: MealsRepository
) {
    operator fun invoke(id: String): Flow<Resource<MealDetail>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.fetchMealDetails(id).meals[0].toMeal()
            emit(Resource.Success(response))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}