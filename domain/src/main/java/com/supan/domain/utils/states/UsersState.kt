package com.supan.domain.utils.states

import com.supan.domain.model.UsersModel

data class UsersState(
    val isLoading: Boolean = false,
    val users: List<UsersModel> = mutableListOf(),
    val error: String = ""
)
