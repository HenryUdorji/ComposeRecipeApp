package com.hashconcepts.composerecipeapp.data.remote.dto

import androidx.annotation.Keep

@Keep
data class CategoryDto(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
)