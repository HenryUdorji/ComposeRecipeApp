package com.hashconcepts.composerecipeapp.ui

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.hashconcepts.composerecipeapp.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @created 08/06/2022 - 1:19 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */

@HiltViewModel
class MainViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences
): ViewModel() {

    fun onBoardingShown() {
        sharedPreferences
            .edit()
            .putBoolean(Constants.ONBOARDING_SHOWN, true)
            .apply()
    }

    val showOnboarding = sharedPreferences.getBoolean(Constants.ONBOARDING_SHOWN, false)
}