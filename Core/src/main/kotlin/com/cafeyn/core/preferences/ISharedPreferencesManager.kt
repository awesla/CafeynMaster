package com.cafeyn.core.preferences

import java.io.Serializable

interface ISharedPreferencesManager {
    fun writeToSharedPreferences(pairValue: Pair<String, Any?>)
    fun readFromSharedPreferences(pairValue: Pair<String, Any?>): Serializable?
}