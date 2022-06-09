package com.hashconcepts.composerecipeapp.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.hashconcepts.composerecipeapp.data.onBoardingData
import com.hashconcepts.composerecipeapp.ui.MainViewModel
import com.hashconcepts.composerecipeapp.ui.components.OnBoardingIndicator
import com.hashconcepts.composerecipeapp.ui.components.RoundedCornerButton
import com.hashconcepts.composerecipeapp.ui.theme.ComposeRecipeAppTheme
import com.hashconcepts.composerecipeapp.ui.theme.OnBoardingBG
import com.hashconcepts.composerecipeapp.ui.theme.White
import com.hashconcepts.composerecipeapp.ui.navigation.Screens

/**
 * @created 06/06/2022 - 3:12 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val pagerState = rememberPagerState(0)
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setNavigationBarColor(color = OnBoardingBG)
        systemUiController.setStatusBarColor(color = OnBoardingBG)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(OnBoardingBG)
            .padding(15.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            HorizontalPager(
                verticalAlignment = Alignment.CenterVertically,
                count = 3,
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) { page ->
                PagerItem(page)
            }
            RoundedCornerButton(text = "Get Started") {
                viewModel.onBoardingShown()
                navController.popBackStack()
                navController.navigate(Screens.HomeScreen.route)
            }
        }
    }
}

@Composable
fun PagerItem(page: Int) {
    val onBoardingItem = onBoardingData(page)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = onBoardingItem.image),
            contentDescription = "Buger",
            modifier = Modifier
                .scale(2f)
                .fillMaxWidth(),
            Alignment.Center
        )
        Text(
            text = onBoardingItem.mainTitle,
            style = MaterialTheme.typography.h1,
            fontSize = 40.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(top = 80.dp, bottom = 25.dp)
        )
        Text(
            text = onBoardingItem.subTitle,
            style = MaterialTheme.typography.body1,
            fontSize = 30.sp,
            color = White,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(bottom = 60.dp)
        )
        OnBoardingIndicator(page)
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardScreenPreview() {
    ComposeRecipeAppTheme {
        OnBoardingScreen(rememberNavController())
    }
}