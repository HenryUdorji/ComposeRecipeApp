package com.hashconcepts.composerecipeapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.hashconcepts.composerecipeapp.R

val gilroy = FontFamily(
    listOf(
        Font(R.font.gilroy_light, FontWeight.Light),
        Font(R.font.gilroy_extra_bold, FontWeight.ExtraBold)
    )
)
// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Black
    ),
    h1 = TextStyle(
        fontFamily = gilroy,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 30.sp,
        color = White
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)