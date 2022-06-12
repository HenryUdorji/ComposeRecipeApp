package com.hashconcepts.composerecipeapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.hashconcepts.composerecipeapp.ui.screens.home.HomeScreen
import com.hashconcepts.composerecipeapp.ui.theme.*
import com.hashconcepts.composerecipeapp.util.noRippleClickable

/**
 * @created 10/06/2022 - 4:52 AM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */
@Composable
fun MealCategoryItem(
    index: Int,
    title: String,
    imageUrl: String,
    isSelected: Boolean,
    onItemClick: (Int) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .background(if (isSelected) Red else InactiveCategory)
            .padding(10.dp)
            .noRippleClickable { onItemClick.invoke(index) }
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .background(White)
                .size(30.dp)
        )
        Spacer(modifier = Modifier.width(40.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.body1,
            color = if (isSelected) White else Black,
            modifier = Modifier.padding(end = 20.dp)
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun MealCategoryItemPreview() {
//    ComposeRecipeAppTheme {
//        MealCategoryItem(
//            1,
//            "Chicken",
//            "https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/1548772327.jpg",
//            true
//        ) {}
//    }
//}