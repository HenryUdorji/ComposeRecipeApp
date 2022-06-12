package com.hashconcepts.composerecipeapp.util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

/**
 * @created 11/06/2022 - 3:02 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */


/***
 * Extension function to remove ripple effect
 * from compose modifiers
 */
inline fun Modifier.noRippleClickable(crossinline onClick: ()->Unit): Modifier = composed {
    clickable(indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}