package com.example.twitterclonegpt.ui.messeges

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.twitterclonegpt.R
import com.example.twitterclonegpt.ui.theme.White

//TODO: change whole screen
@Composable
fun ChatScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White)
    ) {
        ChatContent()
        ChatInput()
    }
}

//TODO: Extract to repo/ constant for now
@Composable
fun ChatContent() {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .padding(top = 16.dp)
    ) {
        ChatMessageView("Hello!")
        ChatMessageView("How are you?")
        ChatMessageView("I'm fine, thanks.")
        ChatMessageView("How about you?")
        ChatMessageView("I'm doing great, thanks!")
        ChatMessageView("Glad to hear that.")
    }
}

@Composable
fun ChatMessageView(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
    ) {
        Surface(
            color = Color(0xffe0e0e0),
            shape = RoundedCornerShape(16.dp),
            elevation = 1.dp,
            modifier = Modifier.size(36.dp)
                .align(CenterVertically)
        ) {
            Image(
                painter = painterResource(id = R.drawable.test_user_image),
                contentDescription = "Center Icon",
                modifier = Modifier
                    .size(16.dp),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Surface(
            color = Color(0xffe0e0e0),
            shape = RoundedCornerShape(16.dp),
            elevation = 1.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = text,
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

// TODO: Rework
@Composable
fun ChatInput() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
        verticalAlignment = CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.twitter_icon_black),
            contentDescription = "Emoji Icon",
            modifier = Modifier
                .size(24.dp)
                .align(CenterVertically)
        )
        Spacer(modifier = Modifier.width(8.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text(text = "Type a message...") },
            modifier = Modifier.weight(1f)
        )
    }
}
