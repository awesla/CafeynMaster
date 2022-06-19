package com.cafeyn.presentation

import android.app.Application
import com.cafeyn.core.preferences.ISharedPreferencesManager
import com.cafeyn.core.utils.BASE_URL_PREFS_KEY
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class CafeynApplication : Application() {

    @Inject
    lateinit var sharedPreferences: ISharedPreferencesManager

    override fun onCreate() {
        super.onCreate()
        sharedPreferences.writeToSharedPreferences(BASE_URL_PREFS_KEY to BuildConfig.BASE_URL)
    }
}