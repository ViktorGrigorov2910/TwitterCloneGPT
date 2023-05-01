package com.example.twitterclonegpt.navigation

sealed class Screen(val route: String) {
    companion object {
        const val HOME = "home_screen"
        const val MESSAGES = "messages_screen"
        const val SETTINGS = "settings_screen"
    }

    object Home : Screen(HOME)
    object Messages : Screen(MESSAGES)
    object Settings : Screen(SETTINGS)
}
