package com.hashconcepts.composerecipeapp.ui.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hashconcepts.composerecipeapp.data.remote.usecases.FetchMealCategoriesUseCase
import com.hashconcepts.composerecipeapp.data.remote.usecases.FilterMealsByCategoryUseCase
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
class HomeViewModel @Inject constructor(
    private val fetchMealCategoriesUseCase: FetchMealCategoriesUseCase,
    private val filterMealsByCategoryUseCase: FilterMealsByCategoryUseCase
) : ViewModel() {

    private val _mealCategoriesState = mutableStateOf(HomeScreenState())
    val mealCategoriesState: State<HomeScreenState> = _mealCategoriesState

    private val _mealsState = mutableStateOf(HomeScreenState())
    val mealsState: State<HomeScreenState> = _mealsState

    var savedPosition = 0

    init {
        fetchMealCategories()
    }

    fun onAction(events: HomeScreenEvents) {
        when(events) {
            is HomeScreenEvents.OnSearchInputKeyed -> {
                //Todo -> implement Search
            }
            is HomeScreenEvents.OnCategorySelected -> {
                filterMealsByCategory(events.category)
            }
        }
    }

    private fun fetchMealCategories() {
        fetchMealCategoriesUseCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _mealCategoriesState.value = HomeScreenState(isLoading = true)
                }
                is Resource.Error -> {
                    _mealCategoriesState.value = HomeScreenState(error = result.message!!)
                }
                is Resource.Success -> {
                    _mealCategoriesState.value = HomeScreenState(mealCategories = result.data?.categories!!)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun filterMealsByCategory(category: String) {
        filterMealsByCategoryUseCase(category).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _mealsState.value = HomeScreenState(mealsLoading = true)
                }
                is Resource.Error -> {
                    _mealsState.value = HomeScreenState(mealsError = result.message!!)
                }
                is Resource.Success -> {
                    _mealsState.value = HomeScreenState(mealByCategory = result.data?.meals!!)
                }
            }
        }.launchIn(viewModelScope)
    }
}