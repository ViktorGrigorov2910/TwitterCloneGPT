package com.example.twitterclonegpt.ui.splashscreen

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.example.twitterclonegpt.R
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.twitterclonegpt.ui.TwitterCloneActivity
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplashScreen(activity: Activity) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 1500
        )
    )
    Splash(alpha = alphaAnim.value)

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(1500)
        val intent = Intent(activity.baseContext, TwitterCloneActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        activity.baseContext.startActivity(intent)
        activity.finish()
    }
}

@Composable
fun Splash(alpha: Float) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .border(
                    BorderStroke(1.dp, Color.Black),
                    CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.twitter_icon_black),
                contentDescription = "My Logo",
                modifier = Modifier
                    .alpha(alpha = alpha)
                    .padding(8.dp)
                    .size(64.dp)
            )
        }
    }
}