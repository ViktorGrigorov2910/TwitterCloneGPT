package com.example.twitterclonegpt.data

import com.example.twitterclonegpt.domain.DataResult
import com.example.twitterclonegpt.ui.messeges.ChatMessage

interface ChatRepositoryContract {

    suspend fun getMessages():DataResult<List<ChatMessage>>

    suspend fun addMessage(newMessage: String):DataResult<Unit>


}