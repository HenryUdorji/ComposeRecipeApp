package com.hashconcepts.composerecipeapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.hashconcepts.composerecipeapp.ui.theme.InActiveIndicator
import com.hashconcepts.composerecipeapp.ui.theme.White

@Composable
fun OnBoardingIndicator(
    currentPosition: Int
) {
    Row(horizontalArrangement = Arrangement.Start) {
        Indicator(currentPosition = currentPosition, position = 0)
        Spacer(modifier = Modifier.width(7.dp))
        Indicator(currentPosition = currentPosition, position = 1)
        Spacer(modifier = Modifier.width(7.dp))
        Indicator(currentPosition = currentPosition, position = 2)
    }
}

@Composable
fun Indicator(currentPosition: Int, position: Int, ) {
    Box(
        modifier = Modifier
            .width(60.dp)
            .height(5.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(if (currentPosition == position) White else InActiveIndicator)
    )
}