package com.hashconcepts.composerecipeapp.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @created 06/06/2022 - 3:01 PM
 * @project ComposeRecipeApp
 * @author  ifechukwu.udorji
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesSharedPreferences(application: Application): SharedPreferences {
        return application.getSharedPreferences("ComposeRecipe-pref", Context.MODE_PRIVATE)
    }


}