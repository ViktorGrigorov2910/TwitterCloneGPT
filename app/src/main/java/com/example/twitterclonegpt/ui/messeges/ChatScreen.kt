package com.example.twitterclonegpt.ui.messeges

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import com.example.twitterclonegpt.R
import com.example.twitterclonegpt.ui.theme.Black
import com.example.twitterclonegpt.ui.theme.White
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//TODO: Create repo and usecases for messages
val chatMessages = listOf(
    ChatMessage("Alice"),
    ChatMessage("ggadsg"),
    ChatMessage("fasasfafas"),
    ChatMessage("bvcbvcbbcvb"),
    ChatMessage("bvcbvcbbcvb"),
    ChatMessage("bvcbvcbbcvb"),
    ChatMessage("bvcbvcbbcvb"),
    ChatMessage("bvcbvcbbcvb"),
    ChatMessage("bvcbvcbbcvb"),
    ChatMessage("bvcbvcbbcvb"),
    ChatMessage("bvcbvcbbcvb"),
    ChatMessage("bvcbvcbbcvb"),
    ChatMessage("bvcbvcbbcvb"),
    ChatMessage("bvcbvcbbcvb"),
    ChatMessage("bvcbvcbbcvb"),
    ChatMessage("bvcbvcbbcvb"),
    ChatMessage("cczxczvxcvxcv"),
    ChatMessage("kuyujyjyuyyujk")
)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ChatScreen() {
    val messages = remember { mutableStateListOf<ChatMessage>() }
    messages.addAll(chatMessages)
    Scaffold(
        bottomBar = {
            ChatInput(messages)
            Spacer(modifier = Modifier.height(120.dp))
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(0.8f)
        ) {
            ChatContent(messages)
        }
    }
}
@Composable
fun ChatInput(messages: SnapshotStateList<ChatMessage>) {
    val newMessage = remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = CenterVertically
    ) {
        TextField(
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp),
            value = newMessage.value,
            onValueChange = { value -> newMessage.value = value },
            placeholder = { Text("What's happening?") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                cursorColor = Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(16.dp)
        )

        Button(
            onClick = {
                if (newMessage.value.isNotBlank()) {
                    val message = ChatMessage(newMessage.value)
                    messages.add(messages.size, message)
                    newMessage.value = ""
                }
            },
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Black
            )
        ) {
            Text(
                text = "Tweet",
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}


@Composable
fun ChatContent(chatMessages: List<ChatMessage>) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LazyColumn(state = listState) {
        items(chatMessages) { chatMessage ->
            ChatMessageView(chatMessage)
        }
    }

    LaunchedEffect(chatMessages.size) {
        coroutineScope.launch {
            listState.scrollToItem(chatMessages.size - 1)
        }
    }

}

@Composable
fun ChatMessageView(message: ChatMessage) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
    ) {
        Surface(
            color = Color(0xffe0e0e0),
            shape = RoundedCornerShape(16.dp),
            elevation = 1.dp,
            modifier = Modifier
                .size(36.dp)
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
                text = message.message,
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

