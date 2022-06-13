package com.hashconcepts.composerecipeapp.presentation.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.SystemUiController
import com.hashconcepts.composerecipeapp.R
import com.hashconcepts.composerecipeapp.ui.theme.Black
import com.hashconcepts.composerecipeapp.ui.theme.OffWhite
import com.hashconcepts.composerecipeapp.ui.theme.Red
import com.hashconcepts.composerecipeapp.ui.theme.White
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

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


        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(OffWhite)
        ) {
            detailScreenState.mealDetail?.let { mealDetail ->
                LazyColumn(content = {
                    item {
                        AsyncImage(
                            model = mealDetail.strMealThumb,
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.width(15.dp))

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 15.dp)
                        ) {
                            Text(
                                text = mealDetail.strMeal,
                                style = MaterialTheme.typography.h1,
                                fontSize = 20.sp,
                                color = Black
                            )
                            Row(
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    modifier = Modifier.size(20.dp),
                                    painter = painterResource(id = R.drawable.ic_category),
                                    contentDescription = null,
                                    tint = Color.Unspecified
                                )
                                Spacer(modifier = Modifier.width(15.dp))
                                Text(
                                    text = mealDetail.strCategory,
                                    style = MaterialTheme.typography.body1
                                )
                            }
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