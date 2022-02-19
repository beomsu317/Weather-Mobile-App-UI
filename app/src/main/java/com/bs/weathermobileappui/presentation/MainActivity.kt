package com.bs.weathermobileappui.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.bs.weathermobileappui.presentation.ui.theme.WeatherMobileAppUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherMobileAppUITheme {

            }
        }
    }
}