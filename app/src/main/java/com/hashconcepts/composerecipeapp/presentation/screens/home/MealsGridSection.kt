package com.hashconcepts.composerecipeapp.presentation.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.hashconcepts.composerecipeapp.presentation.components.MealItem
import com.hashconcepts.composerecipeapp.ui.theme.Red

/**
 * @created 12/06/2022 - 5:05 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */
@Composable
fun ColumnScope.MealsGridSection(
    showSubList: Boolean,
    onMealItemClick: (String) -> Unit,
    onFilterMealByCategory: () -> HomeScreenState
) {
    val mealsState = onFilterMealByCategory.invoke()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
            .weight(1f)
    ) {
        if (mealsState.mealsByCategory.isNotEmpty()) {
            val meals = if (showSubList && mealsState.mealsByCategory.size > 10) {
                mealsState.mealsByCategory.subList(0, 10)
            } else {
                mealsState.mealsByCategory
            }

            LazyVerticalGrid(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                columns = GridCells.Fixed(2),
                content = {
                    items(meals) { meal ->
                        MealItem(
                            mealCategory = meal,
                            onItemClick = {
                                onMealItemClick(meal.idMeal)
                            }
                        )
                    }
                })

        }

        if (mealsState.mealsError.isNotBlank()) {
            Text(
                text = mealsState.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

        if (mealsState.mealsLoading) {
            CircularProgressIndicator(
                color = Red,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}