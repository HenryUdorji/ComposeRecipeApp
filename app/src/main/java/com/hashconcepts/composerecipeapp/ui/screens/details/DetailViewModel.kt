package com.hashconcepts.composerecipeapp.ui.screens.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.hashconcepts.composerecipeapp.data.remote.usecases.FetchMealDetailsUseCase
import com.hashconcepts.composerecipeapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
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

    fun fetchMealDetail(mealId: String) {
        detailsUseCase(mealId).onEach { result ->
            when(result) {
                is Resource.Loading -> {
                    _detailScreenState.value = DetailScreenState(isLoading = true)
                }
                is Resource.Error -> {
                    _detailScreenState.value = DetailScreenState(error = result.message!!)
                }
                is Resource.Success -> {
                    _detailScreenState.value = DetailScreenState(mealDetail = result.data?.meals?.get(0))
                }
            }
        }
    }
}