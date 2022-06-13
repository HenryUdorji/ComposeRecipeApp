package com.hashconcepts.composerecipeapp.presentation.screens.details

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
}