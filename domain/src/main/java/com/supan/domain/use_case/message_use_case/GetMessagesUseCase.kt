package com.supan.domain.use_case.message_use_case

import com.supan.domain.model.ChatModel
import com.supan.domain.repository.MessageRepository
import com.supan.domain.utils.Resource
import javax.inject.Inject

class GetMessagesUseCase @Inject constructor(private val messageRepository: MessageRepository) {

    operator fun invoke(chatId: String, fireBaseResponse: (Resource<List<ChatModel>>) -> Unit) {

        messageRepository.getMessages(chatId) {
            fireBaseResponse(it)
        }
    }
}