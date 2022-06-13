package com.hashconcepts.composerecipeapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.hashconcepts.composerecipeapp.R
import com.hashconcepts.composerecipeapp.ui.screens.home.HomeScreen
import com.hashconcepts.composerecipeapp.ui.theme.*

/**
 * @created 11/06/2022 - 3:18 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */

@Composable
fun SearchBar(
    text: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = text,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = InactiveCategory,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Red
        ),
        textStyle = MaterialTheme.typography.body1,
        shape = RoundedCornerShape(32.dp),
        singleLine = true,
        placeholder = {
            Text(
                text = "Search",
                color = OnBoardingBG
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search",
                tint = Red
            )
        },
    )
}

//@Preview(showBackground = true)
//@Composable
//fun SearchBarPreview() {
//    ComposeRecipeAppTheme {
//        SearchBar("hello") {}
//    }
//}