package com.supan.domain.utils.states


data class AuthState (
    val isLoading: Boolean = false,
    val authState: String = "",
    val error: String = ""
)
