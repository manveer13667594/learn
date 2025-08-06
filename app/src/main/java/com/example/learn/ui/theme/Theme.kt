package com.example.learn.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryDarkColor,
    onPrimary = PrimaryDarkText,
    primaryContainer = PrimaryDarkColor,
    onPrimaryContainer = PrimaryDarkText,

    secondary = SecondaryDarkColor,
    onSecondary = SecondaryDarkText,
    secondaryContainer = SecondaryDarkColor,
    onSecondaryContainer = SecondaryDarkText,

    background = BackgroundDarkColor,
    onBackground = PrimaryDarkText,

    surface = BackgroundDarkScreenColor,
    onSurface = PrimaryDarkText,
    surfaceVariant = SecondaryDarkColor,
    onSurfaceVariant = SecondaryDarkText,

    outline = SecondaryDarkText,
    outlineVariant = SecondaryDarkColor,

    inverseSurface = BackgroundLightScreenColor,
    inverseOnSurface = PrimaryLightText,
    inversePrimary = PrimaryLightColor,

    surfaceTint = PrimaryDarkColor
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryLightColor,
    onPrimary = PrimaryLightText,
    primaryContainer = PrimaryLightColor,
    onPrimaryContainer = PrimaryLightText,

    secondary = SecondaryLightColor,
    onSecondary = SecondaryLightText,
    secondaryContainer = SecondaryLightColor,
    onSecondaryContainer = SecondaryLightText,

    background = BackgroundLightColor,
    onBackground = PrimaryLightText,

    surface = BackgroundLightScreenColor,
    onSurface = PrimaryLightText,
    surfaceVariant = SecondaryLightColor,
    onSurfaceVariant = SecondaryLightText,

    outline = SecondaryLightText,
    outlineVariant = SecondaryLightColor,

    inverseSurface = BackgroundDarkScreenColor,
    inverseOnSurface = PrimaryDarkText,
    inversePrimary = PrimaryDarkColor,

    surfaceTint = PrimaryLightColor
)

@Composable
fun LearnTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false, // Set to false to use your custom colors
    content: @Composable () -> Unit
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