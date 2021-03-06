package com.hashconcepts.composerecipeapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.hashconcepts.composerecipeapp.data.remote.dto.mealByCategory.MealDto
import com.hashconcepts.composerecipeapp.domain.models.MealCategory
import com.hashconcepts.composerecipeapp.ui.theme.White

/**
 * @created 11/06/2022 - 4:03 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */

@Composable
fun MealItem(
    mealCategory: MealCategory,
    onItemClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(White)
            .clickable(onClick = onItemClick)
    ) {
        Column {
            AsyncImage(
                model = mealCategory.strMealThumb,
                contentDescription = null,
                alignment = Alignment.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(White)
            )
//            Spacer(modifier = Modifier.height(20.dp))
//            Text(
//                text = meal.strMeal,
//                style = MaterialTheme.typography.h2,
//                fontSize = 14.sp,
//                color = Black,
//                maxLines = 1,
//                textAlign = TextAlign.Start,
//                overflow = TextOverflow.Ellipsis,
//                modifier = Modifier.padding(horizontal = 15.dp)
//            )
        }
    }
}
