package com.hashconcepts.composerecipeapp.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.hashconcepts.composerecipeapp.ui.components.MealCategoryItem
import com.hashconcepts.composerecipeapp.ui.components.MealItem
import com.hashconcepts.composerecipeapp.ui.components.MealsGridSection
import com.hashconcepts.composerecipeapp.ui.components.SearchBar
import com.hashconcepts.composerecipeapp.ui.navigation.MainActions
import com.hashconcepts.composerecipeapp.ui.theme.*

/**
 * @created 08/06/2022 - 2:09 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */

@Composable
fun ViewMoreScreen(
    actions: MainActions,
    category: String
) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setNavigationBarColor(color = OffWhite)
        systemUiController.setStatusBarColor(color = OffWhite)
    }

    val viewModel = hiltViewModel<HomeViewModel>()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(OffWhite)
            .padding(vertical = 15.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = category,
                style = MaterialTheme.typography.body1,
                color = Black,
                fontSize = 25.sp,
                modifier = Modifier.padding(horizontal = 15.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))
            
            MealsGridSection(
                category = category,
                viewModel = viewModel,
                modifier = Modifier
                    .weight(1f)
                    .padding(0.dp),
                actions = actions,
                showSubList = false
            )
        }
    }
}
