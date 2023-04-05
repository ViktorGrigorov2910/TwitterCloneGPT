package com.example.twitterclonegpt.domain.chat

import com.example.twitterclonegpt.data.ChatRepositoryContract
import com.example.twitterclonegpt.domain.DataResult
import com.example.twitterclonegpt.domain.UseCase
import com.example.twitterclonegpt.ui.messeges.ChatMessage
import javax.inject.Inject

class GetChatMessagesUseCase @Inject constructor(
    private val chatMessageRepositoryContract: ChatRepositoryContract
) : UseCase<Unit, DataResult<List<ChatMessage>>> {

    override suspend fun execute(param: Unit): DataResult<List<ChatMessage>> =
        chatMessageRepositoryContract.getMessages()


}