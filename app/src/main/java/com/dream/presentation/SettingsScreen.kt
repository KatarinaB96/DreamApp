package com.dream.presentation

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.LocaleListCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.dream.R
import com.dream.presentation.viemodels.SettingsViewModel

@Composable
fun SettingsScreen() {
    val viewModel = hiltViewModel<SettingsViewModel>()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.change_language),
            fontSize = 24.sp,
            color = Color(0xFF32CD32),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            viewModel.localeOptions.keys.forEach { localeText ->
                Button(
                    onClick = {
                        viewModel.localeOptions[localeText]?.let { viewModel.setLanguage(it) }
                        val getLanguage = viewModel.getLanguage()
                        AppCompatDelegate.setApplicationLocales(
                            LocaleListCompat.forLanguageTags(getLanguage)
                        )
                    },
                    modifier = Modifier.padding(end = 16.dp)
                ) {
                    Text(text = localeText)
                }
            }
        }
    }
}
