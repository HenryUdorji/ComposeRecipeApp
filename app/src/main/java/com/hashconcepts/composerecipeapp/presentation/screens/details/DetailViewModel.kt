package com.hashconcepts.composerecipeapp.presentation.screens.details

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hashconcepts.composerecipeapp.domain.models.MealDetail
import com.hashconcepts.composerecipeapp.domain.usecases.FetchMealDetailsUseCase
import com.hashconcepts.composerecipeapp.util.Constants
import com.hashconcepts.composerecipeapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * @created 08/06/2022 - 1:19 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailsUseCase: FetchMealDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _detailScreenState = mutableStateOf(DetailScreenState())
    val detailScreenState: State<DetailScreenState> = _detailScreenState

    init {
        savedStateHandle.get<String>(Constants.ARGS_MEAL_ID)?.let { mealId ->
            fetchMealDetail(mealId)
        }
    }

    private fun fetchMealDetail(mealId: String) {
        detailsUseCase(mealId).onEach { result ->
            when(result) {
                is Resource.Loading -> {
                    _detailScreenState.value = DetailScreenState(isLoading = true)
                }
                is Resource.Error -> {
                    _detailScreenState.value = DetailScreenState(error = result.message!!)
                }
                is Resource.Success -> {
                    _detailScreenState.value = DetailScreenState(mealDetail = result.data!!)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun extractIngredientsFromDetails(mealDetail: MealDetail): MutableList<String> {
        val ingredients = mutableListOf<String>()
        if (mealDetail.strIngredient1?.isNotEmpty() == true) ingredients.add(mealDetail.strIngredient1)
        if (mealDetail.strIngredient2?.isNotEmpty() == true) ingredients.add(mealDetail.strIngredient2)
        if (mealDetail.strIngredient3?.isNotEmpty() == true) ingredients.add(mealDetail.strIngredient3)
        if (mealDetail.strIngredient4?.isNotEmpty() == true) ingredients.add(mealDetail.strIngredient4)
        if (mealDetail.strIngredient5?.isNotEmpty() == true) ingredients.add(mealDetail.strIngredient5)
        if (mealDetail.strIngredient6?.isNotEmpty() == true) ingredients.add(mealDetail.strIngredient6)
        if (mealDetail.strIngredient7?.isNotEmpty() == true) ingredients.add(mealDetail.strIngredient7)
        if (mealDetail.strIngredient8?.isNotEmpty() == true) ingredients.add(mealDetail.strIngredient8)
        if (mealDetail.strIngredient9?.isNotEmpty() == true) ingredients.add(mealDetail.strIngredient9)
        if (mealDetail.strIngredient10?.isNotEmpty() == true) ingredients.add(mealDetail.strIngredient10)
        if (mealDetail.strIngredient11?.isNotEmpty() == true) ingredients.add(mealDetail.strIngredient11)
        if (mealDetail.strIngredient12?.isNotEmpty() == true) ingredients.add(mealDetail.strIngredient12)
        if (mealDetail.strIngredient13?.isNotEmpty() == true) ingredients.add(mealDetail.strIngredient13)
        if (mealDetail.strIngredient14?.isNotEmpty() == true) ingredients.add(mealDetail.strIngredient14)
        if (mealDetail.strIngredient15?.isNotEmpty() == true) ingredients.add(mealDetail.strIngredient15)
        if (mealDetail.strIngredient16?.isNotEmpty() == true) ingredients.add(mealDetail.strIngredient16)
        if (mealDetail.strIngredient17?.isNotEmpty() == true) ingredients.add(mealDetail.strIngredient17)
        if (mealDetail.strIngredient18?.isNotEmpty() == true) ingredients.add(mealDetail.strIngredient18)
        if (mealDetail.strIngredient19?.isNotEmpty() == true) ingredients.add(mealDetail.strIngredient19)
        if (mealDetail.strIngredient20?.isNotEmpty() == true) ingredients.add(mealDetail.strIngredient20)

        return ingredients
    }
}