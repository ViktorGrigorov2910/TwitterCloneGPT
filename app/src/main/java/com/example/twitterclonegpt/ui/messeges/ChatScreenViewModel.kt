package com.example.twitterclonegpt.ui.messeges

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.twitterclonegpt.domain.DataResult
import com.example.twitterclonegpt.domain.chat.GetChatMessagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class ChatScreenViewModel @Inject constructor(
    private val getChatMessagesUseCase: GetChatMessagesUseCase,
) : ViewModel() {

    private val _chatMessagesState = MutableLiveData<ChatMessagesState>()
    val chatMessagesState: LiveData<ChatMessagesState> = _chatMessagesState


    init {
        getChatMessages()
    }

    private fun getChatMessages() {
        viewModelScope.launch {
            _chatMessagesState.value = ChatMessagesState.Loading
            delay(2000L)

            when (val result = getChatMessagesUseCase.execute(Unit)) {
                is DataResult.Failure -> _chatMessagesState.value =
                    ChatMessagesState.Failure(result.error)
                is DataResult.Success -> {
                    _chatMessagesState.value = ChatMessagesState.Success(result.value)
                }
            }

        }
    }

    fun addMessage(newMessage: ChatMessage) {
        Unit
        TODO("Create AddMessageUseCase + Add in Repository")
    }

    sealed class ChatMessagesState() {
        object Loading : ChatMessagesState()
        data class Failure(val exception: Exception) : ChatMessagesState()
        data class Success(val chatMessages: List<ChatMessage>) : ChatMessagesState()
    }

}