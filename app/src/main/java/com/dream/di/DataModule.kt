package com.dream.di

import android.content.Context
import com.dream.data.preferences.DeviceSharedPreferences
import com.dream.data.preferences.DeviceSharedPreferencesImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context): DeviceSharedPreferences {
        return DeviceSharedPreferencesImpl(context)
    }
}