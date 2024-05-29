package com.dream.data.preferences

interface DeviceSharedPreferences {
    fun setLanguage(language: String)
    fun getLanguage(): String
}