package com.example.twitterclonegpt.navigation

sealed class Screen(val route: String) {
    companion object {
        const val SPLASH = "splash_screen"
        const val HOME = "home_screen"
        const val MESSAGES = "messages_screen"
        const val SETTINGS = "settings_screen"
    }

    object Splash : Screen(SPLASH)
    object Home : Screen(HOME)
    object Messages : Screen(MESSAGES)
    object Settings : Screen(SETTINGS)
}
