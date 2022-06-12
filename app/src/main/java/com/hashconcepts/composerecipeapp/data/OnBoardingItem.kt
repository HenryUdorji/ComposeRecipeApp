package com.hashconcepts.composerecipeapp.data

import androidx.annotation.DrawableRes
import com.hashconcepts.composerecipeapp.R

/**
 * @created 06/06/2022 - 5:11 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */
data class OnBoardingItem(
    val image: Int,
    val mainTitle: String,
    val subTitle: String
)

fun provideOnBoardingData(): List<OnBoardingItem> {
    return listOf(
        OnBoardingItem(
            image = R.drawable.buger,
            mainTitle = "Grab your \nDelicious food!",
            subTitle = "Delivery food on your phone"
        ),
        OnBoardingItem(
            image = R.drawable.sandwich,
            mainTitle = "Grab your \nDelicious food!",
            subTitle = "Delivery food on your phone"
        ),
        OnBoardingItem(
            image = R.drawable.pizza,
            mainTitle = "Grab your \nDelicious food!",
            subTitle = "Delivery food on your phone"
        )
    )
}

fun onBoardingData(position: Int): OnBoardingItem {
    return when (position) {
        0 -> provideOnBoardingData()[0]
        1 -> provideOnBoardingData()[1]
        2 -> provideOnBoardingData()[2]
        else -> provideOnBoardingData()[0]
    }
}
