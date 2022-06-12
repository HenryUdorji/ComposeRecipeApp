package com.hashconcepts.composerecipeapp.ui.screens.splash

import android.annotation.SuppressLint
import android.util.Log
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.hashconcepts.composerecipeapp.R
import com.hashconcepts.composerecipeapp.ui.navigation.MainActions
import com.hashconcepts.composerecipeapp.ui.navigation.Screens
import com.hashconcepts.composerecipeapp.ui.screens.onboarding.OnBoardingViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @created 12/06/2022 - 9:28 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */
@Composable
fun SplashScreen(
    navController: NavHostController,
    viewModel: OnBoardingViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        delay(3000)
        if (!viewModel.showOnboarding) {
            navController.navigate(Screens.OnBoardingScreen.route)
        } else {
            navController.navigate(Screens.HomeScreen.route)
        }
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(150.dp),
                painter = painterResource(id = R.drawable.pizza),
                contentDescription = "Logo"
            )
        }
    }
}