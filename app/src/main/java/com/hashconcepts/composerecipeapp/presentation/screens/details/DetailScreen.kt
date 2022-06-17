package com.hashconcepts.composerecipeapp.presentation.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.SystemUiController
import com.hashconcepts.composerecipeapp.domain.models.MealDetail
import com.hashconcepts.composerecipeapp.presentation.components.IngredientsItem
import com.hashconcepts.composerecipeapp.ui.theme.Black
import com.hashconcepts.composerecipeapp.ui.theme.OffWhite
import com.hashconcepts.composerecipeapp.ui.theme.Red
import com.hashconcepts.composerecipeapp.ui.theme.White
import com.hashconcepts.composerecipeapp.util.watchYoutubeVideo


/**
 * @created 12/06/2022 - 9:17 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */
@Composable
fun DetailScreen(
    navController: NavHostController,
    systemUiController: SystemUiController,
) {
    ProvideWindowInsets {
        SideEffect {
            systemUiController.setNavigationBarColor(color = OffWhite)
            systemUiController.setStatusBarColor(color = Color.Transparent)
        }

        val viewModel = hiltViewModel<DetailViewModel>()

        val detailScreenState = viewModel.detailScreenState.value

        val context = LocalContext.current

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(OffWhite)
                .padding(bottom = 50.dp)
        ) {
            detailScreenState.mealDetail?.let { mealDetail ->
                val ingredients = viewModel.extractIngredientsFromDetails(mealDetail)

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    content = {
                        item {
                            AsyncImage(
                                model = mealDetail.strMealThumb,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(250.dp),
                                contentScale = ContentScale.Crop
                            )
                        }
                        item {
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = mealDetail.strMeal,
                                style = MaterialTheme.typography.h1,
                                fontSize = 20.sp,
                                color = Black,
                                modifier = Modifier.padding(horizontal = 15.dp)
                            )

                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = "Category: ${mealDetail.strCategory}",
                                style = MaterialTheme.typography.body1,
                                modifier = Modifier.padding(horizontal = 15.dp)
                            )
                        }

                        item {
                            Spacer(modifier = Modifier.height(20.dp))

                            IngredientSection(ingredients)
                        }

//                            item {
//                                Spacer(modifier = Modifier.height(20.dp))
//                                InstructionSection(mealDetail)
//                            }

                        item {
                            Spacer(modifier = Modifier.height(20.dp))

                            Button(
                                elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Red,
                                    contentColor = White
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        top = 20.dp,
                                        bottom = 10.dp,
                                        start = 15.dp,
                                        end = 15.dp
                                    ),
                                shape = RoundedCornerShape(5.dp),
                                onClick = {
                                    watchYoutubeVideo(context, mealDetail.strYoutube)
                                }) {
                                Text(
                                    text = "Watch Video",
                                    style = MaterialTheme.typography.body1,
                                    color = White
                                )
                            }
                        }
                    })
            }

            if (detailScreenState.error.isNotBlank()) {
                Text(
                    text = detailScreenState.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }

            if (detailScreenState.isLoading) {
                CircularProgressIndicator(
                    color = Red,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }

}

@Composable
fun InstructionSection(mealDetail: MealDetail) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
    ) {
        Text(
            text = "Instructions",
            style = MaterialTheme.typography.h2,
            fontSize = 20.sp,
            color = Black
        )

        Text(
            text = mealDetail.strInstructions,
            style = MaterialTheme.typography.body1,
        )
    }
}

@Composable
fun IngredientSection(ingredients: MutableList<String>) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
            .height(300.dp)
    ) {
        Text(
            text = "Ingredients",
            style = MaterialTheme.typography.h2,
            fontSize = 20.sp,
            color = Black
        )
        LazyVerticalGrid(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            columns = GridCells.Fixed(2),
            content = {
                items(ingredients) { ingredient ->
                    IngredientsItem(ingredient = ingredient)
                }
            })
    }
}


