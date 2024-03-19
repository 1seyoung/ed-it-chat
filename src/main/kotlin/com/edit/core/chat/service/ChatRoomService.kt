package com.edit.core.chat.service

import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

@Service
class ChatRoomService {
    private val chatRooms: MutableMap<Long, ChatRoom> = ConcurrentHashMap()

    fun removeUserFromChatRoom(userId: Long, chatRoomId: Long) {
        chatRooms[chatRoomId]?.let { chatRoom ->
            chatRoom.users.remove(userId)
            if (chatRoom.users.isEmpty()) {
                deleteChatRoom(chatRoomId)
            }
        }
    }

    private fun deleteChatRoom(chatRoomId: Long) {
        chatRooms.remove(chatRoomId)
    }
}

data class ChatRoom(val id: Long, val users: MutableSet<Long>)