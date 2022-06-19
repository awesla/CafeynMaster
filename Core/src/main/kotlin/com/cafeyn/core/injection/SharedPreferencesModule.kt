package com.cafeyn.core.injection

import android.content.Context
import android.content.SharedPreferences
import com.cafeyn.core.annotation.CafeynSharedPref
import com.cafeyn.core.preferences.ISharedPreferencesManager
import com.cafeyn.core.preferences.SharedPreferencesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SharedPreferencesModule {

    @Provides
    fun provideSharedPreferencesManager(@CafeynSharedPref preferences: SharedPreferences): ISharedPreferencesManager {
        return SharedPreferencesManager(sharedPref = preferences)
    }

    @Provides
    @CafeynSharedPref
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(
            "shared.preferences.cafeyn",
            Context.MODE_PRIVATE
        )
    }
}