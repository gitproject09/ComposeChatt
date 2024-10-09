package com.supan.domain.utils.states

import com.supan.domain.model.LastMessageModel

data class LastMessageState(
    val isLoading: Boolean = false,
    val messages: List<LastMessageModel> = mutableListOf(),
    val error: String = ""
)
