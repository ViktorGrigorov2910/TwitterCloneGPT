package com.example.twitterclonegpt.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val icon: ImageVector) {
    companion object{
        const val HOME = "home_screen"
        const val MESSAGES = "messages_screen"
        const val SETTINGS = "settings_screen"
    }

    object Home : Screen(HOME, Icons.Default.Home)
    object Messages : Screen(MESSAGES, Icons.Default.AccountBox)
    object Settings : Screen(SETTINGS, Icons.Default.Settings)
}
