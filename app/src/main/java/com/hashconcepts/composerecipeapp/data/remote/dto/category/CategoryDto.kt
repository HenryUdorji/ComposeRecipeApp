package com.hashconcepts.composerecipeapp.data.remote.dto.category

import com.hashconcepts.composerecipeapp.domain.models.Category

data class CategoryDto(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
)

fun CategoryDto.toCategory(): Category {
    return Category(idCategory, strCategory, strCategoryThumb)
}