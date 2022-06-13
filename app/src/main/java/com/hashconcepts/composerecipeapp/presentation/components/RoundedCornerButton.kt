package com.hashconcepts.composerecipeapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hashconcepts.composerecipeapp.ui.theme.ComposeRecipeAppTheme
import com.hashconcepts.composerecipeapp.ui.theme.Red
import com.hashconcepts.composerecipeapp.ui.theme.White

/**
 * @created 06/06/2022 - 3:21 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */

@Composable
fun RoundedCornerButton(
    text: String,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
            .height(70.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Red)
            .clickable(onClick = onClick)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h1,
            fontSize = 20.sp,
            color = White
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun OnBoardScreenPreview() {
//    ComposeRecipeAppTheme {
//        RoundedCornerButton("Get Started"){}
//    }
//}