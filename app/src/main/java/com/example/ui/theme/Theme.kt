package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = CyanAccent,
    onPrimary = Navy900,
    primaryContainer = Navy700,
    onPrimaryContainer = CyanGlow,
    secondary = CyanGlow,
    onSecondary = Navy900,
    background = SurfaceDark,
    onBackground = TextLight,
    surface = CardSurfaceDark,
    onSurface = TextLight,
    surfaceVariant = LineBorderDark,
    onSurfaceVariant = TextLightMuted
)

private val LightColorScheme = lightColorScheme(
    primary = CyanPrimary,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFE0F2FE),
    onPrimaryContainer = Navy900,
    secondary = CyanAccent,
    onSecondary = Color.White,
    background = SurfaceLight,
    onBackground = TextDark,
    surface = CardSurfaceLight,
    onSurface = TextDark,
    surfaceVariant = LineBorderLight,
    onSurfaceVariant = TextMuted
)

@Composable
fun UAVQuizTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Keep custom aerospace theme consistent
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
