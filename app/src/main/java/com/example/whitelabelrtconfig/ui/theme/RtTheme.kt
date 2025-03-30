package com.example.whitelabelrtconfig.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.data.WhiteLabelConfig
import com.example.data.models.DarkColorScheme
import com.example.data.models.LightColorScheme
import com.example.data.models.WhiteLabelConfigTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

val LocalRtTheme = { rtTheme: WhiteLabelConfigTheme -> compositionLocalOf { rtTheme } }

@Composable
fun WhiteLabelRTTheme(
    whiteLabelConfig: WhiteLabelConfigTheme,
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    println("xxxx log theme RT")
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> getDarkColorScheme(whiteLabelConfig.darkColorScheme)
        else -> getLightColorScheme(whiteLabelConfig.lightColorScheme)
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

fun getDarkColorScheme(darkColorScheme: DarkColorScheme): ColorScheme {
    println("xxxx log cs dark p80 = ${darkColorScheme.primaryPurple80}")
    return darkColorScheme(
        primary = darkColorScheme.primaryPurple80.parseColor(),
        secondary = darkColorScheme.secondaryPurpleGrey80.parseColor(),
        tertiary = darkColorScheme.tertiaryPink80.parseColor(),
        background = darkColorScheme.background.parseColor(),
//        surface = darkColorScheme.surface.parseColor()
    )
}

fun getLightColorScheme(lightColorScheme: LightColorScheme) = lightColorScheme(
    primary = lightColorScheme.primaryPurple40.parseColor(),
    secondary = lightColorScheme.secondaryPurpleGrey40.parseColor(),
    tertiary = lightColorScheme.tertiaryPink40.parseColor(),
    background = lightColorScheme.background.parseColor(),
//    surface = lightColorScheme.surface.parseColor()
)

fun String.parseColor(): Color {
    return Color(android.graphics.Color.parseColor(this))
}