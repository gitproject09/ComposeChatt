package com.supan.domain.use_case.message_use_case


import com.supan.domain.model.LastMessageModel
import com.supan.domain.repository.MessageRepository
import com.supan.domain.utils.Resource
import javax.inject.Inject

class GetLastMessagesUseCase @Inject constructor(private val messageRepository: MessageRepository) {

    operator fun invoke(
        myId: String,
        fireBaseResponse: (Resource<List<LastMessageModel>>) -> Unit
    ) {

        messageRepository.getLastMessages(myId) {
            fireBaseResponse(it)
        }

    }

}