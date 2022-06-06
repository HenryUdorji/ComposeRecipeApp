package com.hashconcepts.composerecipeapp.util

/**
 * @created 06/06/2022 - 3:56 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */
sealed class Screens(val route: String) {
    object OnBoardingScreen: Screens(Constants.ONBOARDING_ROUTE)

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
