package com.nut.cdev.bitcoinapplication.data.cache

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.nut.cdev.bitcoinapplication.DataModule
import com.nut.cdev.bitcoinapplication.SHARED_PREFERENCES_NAME


class MainPreference(private val sharedPreferences: SharedPreferences = getPreferences()) {

    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean =
        sharedPreferences.getBoolean(key, defaultValue)

    fun getString(key: String, defaultValue: String = ""): String =
        sharedPreferences.getString(key, defaultValue) ?: ""

    fun putString(key: String, defaultValue: String = "") {
        sharedPreferences.edit().putString(key, defaultValue).apply()
    }

    fun putDouble(key: String, defaultValue: Double = 0.0): Unit =
        sharedPreferences.edit().putLong(key, java.lang.Double.doubleToRawLongBits(defaultValue))
            .apply()

    fun getDouble(key: String, value: Long = 0L): Double =
        java.lang.Double.longBitsToDouble(sharedPreferences.getLong(key, value))

    fun getLong(key: String, defaultValue: Long = 0L): Long =
        sharedPreferences.getLong(key, defaultValue)

    fun putLong(key: String, value: Long = 0L): Unit =
        sharedPreferences.edit().putLong(key, value).apply()

    fun putBoolean(key: String, defaultValue: Boolean = false): Unit =
        sharedPreferences.edit().putBoolean(key, defaultValue).apply()

    fun removeKey(key: String) {
        getPreferencesEditor().remove(key).apply()
    }

    fun deleteAll() {
        getPreferencesEditor().clear().apply()
    }

    @SuppressLint("CommitPrefEdits")
    private fun getPreferencesEditor(): SharedPreferences.Editor = sharedPreferences.edit()
}

private fun getPreferences(): SharedPreferences {
    val ctx = DataModule.getModuleContext()
    return ctx.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
}
