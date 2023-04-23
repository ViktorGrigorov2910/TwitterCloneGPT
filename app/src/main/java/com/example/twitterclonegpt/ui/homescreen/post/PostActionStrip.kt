package com.example.twitterclonegpt.ui.homescreen.post

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ActionStrip(
    likeCount: Int,
    retweetCount: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {

        //TODO: Call clickAction instead of showing log
        ActionIcon(
            icon = Icons.Default.Favorite,
            count = likeCount,
            contentDescription = "Like",
            clickAction = { Log.i("Testing", "Favorite was clicked") }
        )
        //TODO: Call clickAction instead of showing log
        ActionIcon(
            icon = Icons.Default.Refresh,
            count = retweetCount,
            contentDescription = "Retweet",
            clickAction = {
                Log.i("Testing", "Refresh was clicked")
            }
        )
        //TODO: Call clickAction instead of showing log
        ActionIcon(
            icon = Icons.Default.Share,
            contentDescription = "Share",
            clickAction = { Log.i("Testing", "Share was clicked") }
        )
    }
}


@Composable
fun ActionIcon(
    icon: ImageVector,
    count: Int? = null,
    contentDescription: String,
    clickAction: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text = count?.toString() ?: "",
            fontSize = 14.sp,
            modifier = Modifier.padding(end = 4.dp)
        )
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            modifier = Modifier
                .size(16.dp)
                .clickable(onClick = clickAction)
        )
    }
}