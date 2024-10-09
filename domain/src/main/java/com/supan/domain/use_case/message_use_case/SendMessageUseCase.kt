package com.supan.domain.use_case.message_use_case


import com.supan.domain.repository.MessageRepository
import javax.inject.Inject

class SendMessageUseCase @Inject constructor(private val messageRepository: MessageRepository) {

    operator fun invoke(
        chatId: String,
        messageSenderId: String?,
        messageReceiverId: String?,
        messageSenderName: String?,
        messageReceiverName: String?,
        messageText: String?
    ) =
        messageRepository.sendMessage(
            chatId,
            messageSenderId,
            messageReceiverId,
            messageSenderName,
            messageReceiverName,
            messageText
        )
}