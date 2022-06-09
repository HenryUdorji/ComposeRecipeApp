package com.hashconcepts.composerecipeapp.ui

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hashconcepts.composerecipeapp.data.remote.usecases.FetchMealCategoriesUseCase
import com.hashconcepts.composerecipeapp.data.remote.usecases.FetchMealDetailsUseCase
import com.hashconcepts.composerecipeapp.data.remote.usecases.FilterMealsByCategoryUseCase
import com.hashconcepts.composerecipeapp.util.Constants
import com.hashconcepts.composerecipeapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @created 08/06/2022 - 1:19 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */

@HiltViewModel
class MainViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val fetchMealCategoriesUseCase: FetchMealCategoriesUseCase,
    private val fetchMealDetailsUseCase: FetchMealDetailsUseCase,
    private val filterMealsByCategoryUseCase: FilterMealsByCategoryUseCase
): ViewModel() {

    fun onBoardingShown() {
        sharedPreferences
            .edit()
            .putBoolean(Constants.ONBOARDING_SHOWN, true)
            .apply()
    }

    val showOnboarding = sharedPreferences.getBoolean(Constants.ONBOARDING_SHOWN, false)

    fun fetchMealCategories() {
        fetchMealCategoriesUseCase().onEach { result ->
            when(result) {
                is Resource.Loading -> {
                    Log.d("TAG", "LOADING")
                }
                is Resource.Error -> {
                    Log.d("TAG", "ERROR ${result.message}")
                }
                is Resource.Success -> {
                    Log.d("TAG", "SUCCESS ${result.data?.categories}")
                }
            }
        }.launchIn(viewModelScope)
    }

    fun fetchMealDetails(id: Int) {
        fetchMealDetailsUseCase(id).onEach { result ->
            when(result) {
                is Resource.Loading -> {
                    Log.d("TAG", "LOADING")
                }
                is Resource.Error -> {
                    Log.d("TAG", "ERROR ${result.message}")
                }
                is Resource.Success -> {
                    Log.d("TAG", "SUCCESS ${result.data?.meals}")
                }
            }
        }.launchIn(viewModelScope)
    }

    fun filterMealsByCategory(category: String) {
        filterMealsByCategoryUseCase(category).onEach { result ->
            when(result) {
                is Resource.Loading -> {
                    Log.d("TAG", "LOADING")
                }
                is Resource.Error -> {
                    Log.d("TAG", "ERROR ${result.message}")
                }
                is Resource.Success -> {
                    Log.d("TAG", "SUCCESS ${result.data?.meals}")
                }
            }
        }.launchIn(viewModelScope)
    }
}