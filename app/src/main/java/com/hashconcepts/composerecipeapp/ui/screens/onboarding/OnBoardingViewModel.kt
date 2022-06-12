package com.hashconcepts.composerecipeapp.ui.screens.onboarding

import android.content.SharedPreferences
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hashconcepts.composerecipeapp.data.remote.usecases.FetchMealCategoriesUseCase
import com.hashconcepts.composerecipeapp.data.remote.usecases.FetchMealDetailsUseCase
import com.hashconcepts.composerecipeapp.data.remote.usecases.FilterMealsByCategoryUseCase
import com.hashconcepts.composerecipeapp.ui.screens.home.HomeScreenState
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
class OnBoardingViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : ViewModel() {

    fun onBoardingShown() {
        sharedPreferences
            .edit()
            .putBoolean(Constants.ONBOARDING_SHOWN, true)
            .apply()
    }

    val showOnboarding = sharedPreferences.getBoolean(Constants.ONBOARDING_SHOWN, false)
}