package com.cafeyn.core.extentions

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import com.cafeyn.core.misc.DataWrapper
import com.cafeyn.core.misc.Loading
import java.io.Serializable

fun <T> MutableLiveData<DataWrapper<T>>.setLoadingState(loading: Boolean) {
    this.value = Loading(loading)
}

fun <T : Any?> SharedPreferences.Editor.set(pairValue: Pair<String, T>) {
    when (val value = pairValue.second) {
        is String -> putString(pairValue.first, value).apply()
        is Boolean -> putBoolean(pairValue.first, value).apply()
        is Int -> putInt(pairValue.first, value).apply()
        is Long -> putLong(pairValue.first, value).apply()
        is Float -> putFloat(pairValue.first, value).apply()
    }
}

fun <T : Any?> SharedPreferences.get(keyValue: String, defaultValue: T): Serializable? {
    return when (defaultValue) {
        is String, null -> getString(keyValue, defaultValue.toString())
        is Boolean -> getBoolean(keyValue, defaultValue)
        is Int -> getInt(keyValue, defaultValue.toInt())
        is Float -> getFloat(keyValue, defaultValue.toFloat())
        is Long -> getLong(keyValue, defaultValue.toLong())
        else -> IllegalArgumentException("Type mismatch")
    }
}