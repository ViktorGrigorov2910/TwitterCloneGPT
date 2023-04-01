package com.example.twitterclonegpt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.twitterclonegpt.ui.homescreen.HomeScreen
import com.example.twitterclonegpt.ui.theme.TwitterCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TwitterCloneTheme {
                HomeScreen()
            }
        }
    }
}

