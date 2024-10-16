package com.supan.domain.repository

import com.supan.domain.model.ChatModel
import com.supan.domain.model.LastMessageModel
import com.supan.domain.utils.Resource

interface MessageRepository {

    fun sendMessage(
        chatId: String,
        messageSenderId: String?,
         messageReceiverId: String?,
         messageSenderName: String? ,
         messageReceiverName: String? ,
         messageText: String? ,
    )

    fun getMessages(chatId:String,fireBaseResponse:(Resource<List<ChatModel>>)->Unit)

    fun uploadFile(  chatId: String,
                     messageSenderId: String?,
                     messageReceiverId: String?,
                     messageSenderName: String? ,
                     messageReceiverName: String? ,
                     fileType: String,
                     fileUri: Any,

    )

    fun updateLastMessageForCurrentUser( chatId: String?,
                                   messageSenderName: String?,
                                   messageReceiverName: String?,
                                   messageSenderId: String?,
                                   messageReceiverId: String?,
                                   msgType: String?,
                                   message: String?)

    fun updateLastMessageForPeerUser( chatId: String?,
                                      messageSenderName: String?,
                                      messageReceiverName: String?,
                                      messageSenderId: String?,
                                      messageReceiverId: String?,
                                      msgType: String?,
                                      message: String?)


    fun getLastMessages(myId:String,fireBaseResponse:(Resource<List<LastMessageModel>>)->Unit)

}