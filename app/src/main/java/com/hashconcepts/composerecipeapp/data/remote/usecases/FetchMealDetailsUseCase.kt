package com.hashconcepts.composerecipeapp.data.remote.usecases

import com.hashconcepts.composerecipeapp.data.remote.dto.details.MealDetailsDto
import com.hashconcepts.composerecipeapp.data.remote.repository.MealsRepository
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
    operator fun invoke(id: String): Flow<Resource<MealDetailsDto>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.fetchMealDetails(id)
            emit(Resource.Success(response))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}