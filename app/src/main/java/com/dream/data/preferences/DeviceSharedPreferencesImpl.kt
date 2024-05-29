package com.dream.data.preferences

import android.content.Context
import android.content.SharedPreferences

class DeviceSharedPreferencesImpl(context: Context) : DeviceSharedPreferences {
    companion object {
        private const val SHARED_PREFS_FILE_NAME = "device_preferences"
        private const val LANGUAGE = "language"
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_FILE_NAME, Context.MODE_PRIVATE)

    override fun setLanguage(language: String) {
        val editor = sharedPreferences.edit()
        editor.putString(LANGUAGE, language)
        editor.apply()
    }

    override fun getLanguage(): String {
        return sharedPreferences.getString(LANGUAGE, "en") ?: "en"
    }
}