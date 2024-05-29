package com.dream.presentation.viemodels

import androidx.lifecycle.ViewModel
import com.dream.data.preferences.DeviceSharedPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val sharedPreferences: DeviceSharedPreferences
) : ViewModel() {

    val localeOptions = mapOf(
        "English" to "en",
        "Croatian" to "hr"
    )

    fun setLanguage(languageCode: String) {
        sharedPreferences.setLanguage(languageCode)
    }

    fun getLanguage(): String {
        return sharedPreferences.getLanguage()
    }
}