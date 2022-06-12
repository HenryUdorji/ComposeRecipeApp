package com.hashconcepts.composerecipeapp.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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
fun HomeScreen(
    actions: MainActions
) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setNavigationBarColor(color = OffWhite)
        systemUiController.setStatusBarColor(color = OffWhite)
    }

    val viewModel = hiltViewModel<HomeViewModel>()
    val homeScreenState = viewModel.mealCategoriesState.value

    var selectedIndex by remember { mutableStateOf(viewModel.savedPosition) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(OffWhite)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Find Your \nDelicious Food",
                style = MaterialTheme.typography.body1,
                color = Black,
                fontSize = 25.sp,
                modifier = Modifier.padding(15.dp)
            )

            var text by remember { mutableStateOf("") }
            SearchBar(text = text, onValueChange = { text = it })

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Categories",
                style = MaterialTheme.typography.h2,
                fontSize = 18.sp,
                color = Black,
                modifier = Modifier.padding(horizontal = 15.dp)
            )

            val listState = rememberLazyListState()
            LazyRow(
                state = listState,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp),
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                items(homeScreenState.mealCategories) { category ->
                    MealCategoryItem(
                        index = homeScreenState.mealCategories.indexOf(category),
                        title = category.strCategory,
                        imageUrl = category.strCategoryThumb,
                        isSelected = selectedIndex == homeScreenState.mealCategories.indexOf(
                            category
                        ),
                    ) { index ->
                        selectedIndex = index
                        viewModel.savedPosition = selectedIndex

                        val selectedCategory = homeScreenState.mealCategories[selectedIndex].strCategory
                        viewModel.onAction(HomeScreenEvents.OnCategorySelected(selectedCategory))
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Meals",
                    style = MaterialTheme.typography.h2,
                    fontSize = 20.sp,
                    color = Black,
                )
                Text(
                    text = "View more",
                    style = MaterialTheme.typography.h2,
                    fontSize = 15.sp,
                    color = Red,
                    modifier = Modifier.clickable {
                        val selectedCategory = homeScreenState.mealCategories[selectedIndex].strCategory
                        if (selectedCategory.isNotEmpty()) {
                            actions.gotoViewMoreScreen(selectedCategory)
                        }
                    }
                )
            }

            if (homeScreenState.mealCategories.isNotEmpty()) {
                val selectedCategory = homeScreenState.mealCategories[selectedIndex].strCategory
                MealsGridSection(
                    category = selectedCategory,
                    viewModel = viewModel,
                    modifier = Modifier.weight(1f),
                    actions = actions,
                    showSubList = true
                )
            }
        }

        if (homeScreenState.error.isNotBlank()) {
            Text(
                text = homeScreenState.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

        if (homeScreenState.isLoading) {
            CircularProgressIndicator(
                color = Red,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ComposeRecipeAppTheme {
        val action = MainActions(rememberNavController())
        HomeScreen(action)
    }
}