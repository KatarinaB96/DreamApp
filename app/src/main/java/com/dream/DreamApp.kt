package com.dream

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import com.dream.data.preferences.DeviceSharedPreferences
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class DreamApp : Application() {
    @Inject
    lateinit var sharedPreferences: DeviceSharedPreferences

    override fun onCreate() {
        super.onCreate()
        val selectedLanguage = sharedPreferences.getLanguage()
        AppCompatDelegate.setApplicationLocales(
            LocaleListCompat.forLanguageTags(selectedLanguage)
        )
    }
}