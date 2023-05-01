package com.example.twitterclonegpt.ui

import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.example.twitterclonegpt.R
import com.example.twitterclonegpt.navigation.Screen
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplashScreen(navController: NavHostController) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 2500
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(2500)
        navController.popBackStack()
        navController.navigate(Screen.Home.route)
    }
    Splash(alpha = alphaAnim.value)
}

@Composable
fun Splash(alpha: Float) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
            Image(
                painter = painterResource(R.drawable.twitter_icon_black),
                contentDescription = "My Logo",
                modifier = Modifier
                    .alpha(alpha = alpha)
                    .size(86.dp)
                    .border(
                        BorderStroke(1.dp, Color.Black),
                        CircleShape
                    )
            )
    }
}
