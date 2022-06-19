package com.cafeyn.core.preferences

import android.content.SharedPreferences
import com.cafeyn.core.annotation.CafeynSharedPref
import com.cafeyn.core.extentions.get
import com.cafeyn.core.extentions.set
import java.io.Serializable
import javax.inject.Inject

class SharedPreferencesManager @Inject constructor(
    @CafeynSharedPref private val sharedPref: SharedPreferences
) : ISharedPreferencesManager {

    override fun writeToSharedPreferences(pairValue: Pair<String, Any?>) {
        sharedPref.edit().set(pairValue)
    }

    override fun readFromSharedPreferences(pairValue: Pair<String, Any?>): Serializable? {
        return sharedPref.get(pairValue.first, pairValue.second)
    }
}