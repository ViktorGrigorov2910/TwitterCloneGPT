package com.example.twitterclonegpt.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.twitterclonegpt.navigation.AppBar
import com.example.twitterclonegpt.navigation.BottomNavigationBar
import com.example.twitterclonegpt.navigation.Screen
import com.example.twitterclonegpt.ui.homescreen.HomeScreen
import com.example.twitterclonegpt.ui.messeges.ChatScreen
import com.example.twitterclonegpt.ui.settings.SettingsScreen
import com.example.twitterclonegpt.ui.theme.TwitterCloneTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TwitterCloneActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            TwitterCloneTheme {
                Scaffold(
                    topBar = { AppBar() },
                    bottomBar = { BottomNavigationBar(navController) }
                ) {
                    NavHost(navController, startDestination = Screen.Home.route) {
                        composable(Screen.Home.route) { HomeScreen() }
                        composable(Screen.Messages.route) { ChatScreen() }
                        composable(Screen.Settings.route) { SettingsScreen() }
                    }
                }
            }
        }
    }
}