package com.example.appsl75999886.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val Primary = Color(0xFF0F766E)
private val Secondary = Color(0xFFF97316)
private val Tertiary = Color(0xFF1D4ED8)
private val Background = Color(0xFFF6F7FB)
private val Surface = Color(0xFFFFFFFF)
private val SurfaceVariant = Color(0xFFE7ECF5)

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = Color.White,
    secondary = Secondary,
    onSecondary = Color.White,
    tertiary = Tertiary,
    background = Background,
    onBackground = Color(0xFF102A43),
    surface = Surface,
    onSurface = Color(0xFF102A43),
    surfaceVariant = SurfaceVariant,
    onSurfaceVariant = Color(0xFF52606D)
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF2DD4BF),
    onPrimary = Color(0xFF00332F),
    secondary = Color(0xFFFDBA74),
    onSecondary = Color(0xFF4A2500),
    tertiary = Color(0xFF93C5FD),
    background = Color(0xFF0B1220),
    onBackground = Color(0xFFE5EEF8),
    surface = Color(0xFF101A2E),
    onSurface = Color(0xFFE5EEF8),
    surfaceVariant = Color(0xFF1E293B),
    onSurfaceVariant = Color(0xFFCBD5E1)
)

@Composable
fun AppSl75999886Theme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) DarkColorScheme else LightColorScheme,
        content = content
    )
}
