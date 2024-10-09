
package com.supan.presentation.screens.home_screen.tabs_screen


import android.annotation.SuppressLint
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.supan.presentation.R
import com.supan.presentation.components.ChatRow
import com.supan.presentation.components.getActualTime
import com.supan.presentation.theme.*
import com.supan.presentation.ui.view_models.AuthViewModel
import com.supan.presentation.ui.view_models.ChatPageViewModel
import com.supan.presentation.utiles.Routes
import com.google.firebase.Timestamp


@SuppressLint("SuspiciousIndentation")
@Composable

fun ChatsScreen(
    mainNavController: NavHostController,
    chatPageViewModel: ChatPageViewModel = hiltViewModel(),
    authViewModel: AuthViewModel = hiltViewModel(),

    ) {
     if(authViewModel.getCurrentUser()!=null)
    chatPageViewModel.getLastMessages(authViewModel.getCurrentUser()!!.uid)
    ComposeChatAppTheme {
        Column {
            if (chatPageViewModel.lastMessagesState.value.messages.isEmpty() ||
                chatPageViewModel.lastMessagesState.value.error.isNotEmpty()
            ) {

                Image(
                    painter = painterResource(id = R.drawable.no_messages_blank_state),
                    contentDescription = "logo",
                    Modifier
                        .weight(1f)
                        .fillMaxWidth()
                )

            } else if (chatPageViewModel.lastMessagesState.value.messages.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(darkWhite)
                ){
                    itemsIndexed(
                        items = chatPageViewModel.lastMessagesState.value.messages,
                    ) { index, textMessage ->
                        if(authViewModel.getCurrentUser()!=null) {
                            if (textMessage.msgType == "text") {
                                val message =
                                    if (textMessage.messageSenderId == authViewModel.getCurrentUser()!!.uid)
                                        "you : ${textMessage.message}" else textMessage.message
                                val userName =
                                    if (textMessage.messageSenderId != authViewModel.getCurrentUser()!!.uid)
                                        textMessage.messageSenderName else textMessage.messageReceiverName
                                ChatRow(userName = userName.toString(),
                                    message = message.toString(),
                                    time = getActualTime(textMessage.msgTime as Timestamp),
                                    onChatClick = {
                                        val userId =
                                            if (textMessage.messageSenderId == authViewModel.getCurrentUser()!!.uid)
                                                textMessage.messageReceiverId else textMessage.messageSenderId
                                        mainNavController.navigate(route = Routes().chatScreen + "/$userId") {
                                            launchSingleTop = true

                                        }
                                    })

                            }
                            else {

                                val userName =
                                    if (textMessage.messageSenderId != authViewModel.getCurrentUser()!!.uid)
                                        textMessage.messageSenderName else textMessage.messageReceiverName

                                val message =
                                    if (textMessage.messageSenderId == authViewModel.getCurrentUser()!!.uid)
                                        "you sent ${textMessage.msgType} " else "$userName sent ${textMessage.msgType} "

                                ChatRow(userName = userName.toString(),
                                    message = message.toString(),
                                    time = getActualTime(textMessage.msgTime as Timestamp),
                                    onChatClick = {
                                        val userId =
                                            if (textMessage.messageSenderId == authViewModel.getCurrentUser()!!.uid)
                                                textMessage.messageReceiverId else textMessage.messageSenderId
                                        mainNavController.navigate(route = Routes().chatScreen + "/$userId") {
                                            launchSingleTop = true

                                        }
                                    })


                            }
                        }




                    }
                }
            }



        }
    }
}

