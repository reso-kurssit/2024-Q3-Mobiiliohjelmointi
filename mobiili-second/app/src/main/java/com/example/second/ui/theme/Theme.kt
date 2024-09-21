package com.example.second.ui.theme

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
    primary = OceanBlue,
    onPrimary = QuiteDark,
    primaryContainer = OceanBlue,
    onPrimaryContainer = PureWhite,
    secondary = LightRed,
    onSecondary = BrightRed,
    tertiary = LightGreen,
    onTertiary = DarkGreen,
    tertiaryContainer = PureWhite,
    background = SolidBlue,
    onBackground = PureWhite,
    surface = LightestBrown,
    onSurface = QuiteDark
)

private val LightColorScheme = lightColorScheme(
    primary = SkyBlue,
    onPrimary = OffWhite,
    primaryContainer = OceanBlue,
    onPrimaryContainer = PureWhite,
    secondary = BrightRed,
    onSecondary = LightRed,
    tertiary = DarkGreen,
    onTertiary = LightGreen,
    tertiaryContainer = QuiteDark,
    background = SolidBlue,
    onBackground = PureWhite,
    surface = LightestBrown,
    onSurface = PureWhite
)

@Composable
fun FirstTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
    )
}