package com.khtonapp.diostats.ui.theme

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun DioStatsTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colorScheme = when {
        isDarkTheme -> {
            dynamicDarkColorScheme(LocalContext.current)
        }
        else -> {dynamicLightColorScheme(LocalContext.current)}
    }

    // Make use of Material3
    MaterialTheme(
        colorScheme =  colorScheme,
        content = content
    )
}