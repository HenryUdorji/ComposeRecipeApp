package com.hashconcepts.composerecipeapp.presentation.screens.home

/**
 * @created 12/06/2022 - 4:28 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */
sealed class HomeScreenEvents {
    data class OnCategorySelected(val category: String): HomeScreenEvents()
    data class OnSearchInputKeyed(val searchQuery: String): HomeScreenEvents()
}
