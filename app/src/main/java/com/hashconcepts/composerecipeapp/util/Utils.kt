package com.hashconcepts.composerecipeapp.util

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * @created 14/06/2022 - 4:04 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */

fun watchYoutubeVideo(context: Context, url: String) {
    val intent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse(url)
    )
    try {
        context.startActivity(intent)
    } catch (ex: ActivityNotFoundException) {
    }
}