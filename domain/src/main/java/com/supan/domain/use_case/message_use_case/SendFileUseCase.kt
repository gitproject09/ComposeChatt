package com.supan.domain.use_case.message_use_case


import com.supan.domain.repository.MessageRepository
import javax.inject.Inject

class SendFileUseCase @Inject constructor(private val messageRepository: MessageRepository) {

    operator fun invoke(
        chatId: String,
        messageSenderId: String?,
        messageReceiverId: String?,
        messageSenderName: String?,
        messageReceiverName: String?,
        fileType: String,
        fileUri: Any,
    ) =
        messageRepository.uploadFile(
            chatId,
            messageSenderId,
            messageReceiverId,
            messageSenderName,
            messageReceiverName,
            fileType,
            fileUri,
        )
}