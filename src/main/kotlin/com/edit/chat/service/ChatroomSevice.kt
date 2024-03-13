package com.edit.chat.service

import com.edit.chat.model.Chatroom
import com.edit.chat.repository.ChatroomRepository
import org.springframework.stereotype.Service

@Service
class ChatroomService(private val chatroomRepository: ChatroomRepository) {
    fun createChatroom(name: String): Chatroom {
        val newChatroom = Chatroom(name = name)
        return chatroomRepository.save(newChatroom)
    }
}
