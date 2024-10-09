package com.supan.domain.use_case.auth_use_case

import com.supan.domain.repository.AuthRepository
import javax.inject.Inject

class UpdateUserStatusUseCase @Inject constructor(private val authRepository: AuthRepository) {

    operator fun invoke(userStatus: String, lastSeen: Any?) =
        authRepository.updateUserStatus(userStatus, lastSeen)

}