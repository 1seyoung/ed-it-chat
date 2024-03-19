package com.edit.chat.service

import org.springframework.stereotype.Service

@Service
class ChatService(private val userService: UserService, private val chatRoomService: ChatRoomService) {
    fun leaveChat(username: String, chatRoomId: Long?): Boolean {
        val user = userService.findUserByUsername(username) ?: return false
        chatRoomId?.let {
            userService.leaveChatRoom(user.userid!!)
            chatRoomService.removeUserFromChatRoom(user.userid, it)
            return true
        }
        return false
    }

}