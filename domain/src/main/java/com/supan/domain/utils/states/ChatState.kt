package com.supan.domain.utils.states

import com.supan.domain.model.ChatModel

data class ChatState(
    val isLoading: Boolean = false,
    val messages: List<ChatModel> = mutableListOf(),
    val error: String = ""
)
