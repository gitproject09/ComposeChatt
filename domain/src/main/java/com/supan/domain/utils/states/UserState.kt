package com.supan.domain.utils.states

import com.supan.domain.model.UsersModel


data class UserState (
    val isLoading: Boolean = false,
    val user: List<UsersModel> = mutableListOf(),
    val error: String = ""
)
