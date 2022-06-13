package com.hashconcepts.composerecipeapp.presentation.navigation

import com.hashconcepts.composerecipeapp.util.Constants

/**
 * @created 06/06/2022 - 3:56 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */
sealed class Screens(val route: String) {
    object SplashScreen: Screens(Constants.SPLASH_ROUTE)
    object HomeScreen: Screens(Constants.HOME_ROUTE)
    object DetailScreen: Screens(Constants.DETAIL_ROUTE)
    object ViewMoreScreen: Screens(Constants.VIEW_MORE_ROUTE)

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
