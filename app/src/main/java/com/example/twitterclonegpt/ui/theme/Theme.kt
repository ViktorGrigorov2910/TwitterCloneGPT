package com.example.twitterclonegpt.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val LightColorPalette = lightColors(
    primary = White,
    primaryVariant = White,
    secondary = Black,
    background = White,
    surface = White,
    onPrimary = Black,
    onSecondary = White,
    onBackground = Black,
    onSurface = Black
)

private val DarkColorPalette = darkColors(
    primary = Black,
    primaryVariant = Black,
    secondary = White,
    background = Black,
    surface = Black,
    onPrimary = White,
    onSecondary = Black,
    onBackground = White,
    onSurface = White
)

@Composable
fun TwitterCloneTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    MaterialTheme(
        colors = if (darkTheme) DarkColorPalette else LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = MaterialTheme.colors.isLight

    SideEffect {
        systemUiController.setSystemBarsColor(Black)
        systemUiController.setNavigationBarColor(Black)
        systemUiController.setStatusBarColor(
            if (useDarkIcons) Black else White
        )
    }
}