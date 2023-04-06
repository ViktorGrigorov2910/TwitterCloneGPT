package com.example.twitterclonegpt.ui.messeges

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.twitterclonegpt.R
import com.example.twitterclonegpt.ui.homescreen.HomeScreenViewModel
import com.example.twitterclonegpt.ui.theme.Black
import com.example.twitterclonegpt.ui.utils.ShowError
import com.example.twitterclonegpt.ui.utils.ShowLoading
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ChatScreen() {
    val viewModel: ChatScreenViewModel = hiltViewModel()
    Scaffold { ChatScreenContent(viewModel) }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ChatScreenContent(viewModel: ChatScreenViewModel) = Column(
    modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .fillMaxWidth(1f),
    horizontalAlignment = Alignment.CenterHorizontally

) {
    val messages = remember { mutableStateListOf<ChatMessage>() }
    val chatMessagesState = viewModel.chatMessagesState.observeAsState()

    ShowLoading(isLoading = chatMessagesState.value is ChatScreenViewModel.ChatMessagesState.Loading)

    when (val state = chatMessagesState.value) {
        is ChatScreenViewModel.ChatMessagesState.Loading -> Unit
        is ChatScreenViewModel.ChatMessagesState.Success -> {
            messages.addAll(state.chatMessages)
        }
        else -> {}
    }
    Scaffold(
        bottomBar = {
            ChatInput(messages, viewModel)
            Spacer(modifier = Modifier.height(116.dp))
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
fun ChatInput(messages: SnapshotStateList<ChatMessage>, viewModel: ChatScreenViewModel) {
    val newMessage = remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .height(50.dp),
        verticalAlignment = CenterVertically,
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(
                width = 1.dp,
                color = Black
            )
        ) {
            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                verticalAlignment = CenterVertically
            ) {
                TextField(
                    modifier = Modifier
                        .weight(1f),
                    value = newMessage.value,
                    onValueChange = { value -> newMessage.value = value },
                    placeholder = { Text("Hello....") },
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
                            //TODO: observe if added
//                        viewModel.addMessage(message)
                            messages.add(messages.size, message)
                            newMessage.value = ""
                        }
                    },
                    shape = androidx.compose.foundation.shape.CircleShape,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Black
                    ),
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_send),
                        contentDescription = "Send Button"
                    )
                }
            }
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
            listState.scrollToItem(chatMessages.size)
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

