package com.example.twitterclonegpt.data

import com.example.twitterclonegpt.domain.DataResult
import com.example.twitterclonegpt.domain.asDataResult
import com.example.twitterclonegpt.ui.messeges.ChatMessage
import javax.inject.Inject

//TODO: Remove when db is ready (Room?)
val chatMessages = mutableListOf(
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

class ChatRepository @Inject constructor() : ChatRepositoryContract {
    override suspend fun getMessages(): DataResult<List<ChatMessage>> =
        asDataResult { chatMessages }

    override suspend fun addMessage(newMessage: String): DataResult<Unit> = asDataResult {
        chatMessages.add(chatMessages.size, newMessage.toChatMessage(newMessage))
    }

}

private fun String.toChatMessage(newMessage: String) = ChatMessage(newMessage)
