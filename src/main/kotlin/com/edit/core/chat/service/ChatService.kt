package com.edit.core.chat.service

import com.edit.core.chat.api.dto.respone.ChatHistoryResponse
import com.edit.core.chat.api.dto.respone.MessagesResponse
import com.edit.core.chat.entity.ChatHistory
import com.edit.core.chat.entity.ChatRoom
import com.edit.core.chat.repository.ChatHistoryRepository
import com.edit.core.chat.repository.ChatRoomRepository
import com.edit.core.user.api.dto.response.SimpleUserResponse
import com.edit.core.user.entity.User
import com.edit.core.user.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
@Transactional
class ChatService(
        private val chatRoomRepository: ChatRoomRepository,
        private val chatHistoryRepository: ChatHistoryRepository,
        private val userRepository: UserRepository,
) {

    fun saveChatMessage(roomUUID: String, senderId: Long, message: String): Long {
        val sender = userRepository.findById(senderId).orElseThrow { Exception("User not found") }
        val chatHistory = ChatHistory(
                chatRoomId = roomUUID,
                senderId = sender.id.toString(),
                message = message,
                createdAt = LocalDateTime.now()
        )
        chatHistoryRepository.save(chatHistory)
        return chatHistory.id?.toLong() ?: throw Exception("Chat history not saved")
    }

    fun readChat(chatId: Long) {
        val chatHistory = chatHistoryRepository.findById(chatId.toString()).orElseThrow { Exception("Chat not found") }
        // Implement the logic to mark as read
    }

    fun createChatRoom(userId: Long, otherUserId: Long): ChatRoom {
        // Validate users
        val user = userRepository.findById(userId).orElseThrow { Exception("User not found") }
        val otherUser = userRepository.findById(otherUserId).orElseThrow { Exception("User not found") }

        // Create new chat room
        val chatRoom = ChatRoom(
                // Assuming ChatRoom has a constructor that accepts users or a method to add users
                roomUUID = UUID.randomUUID().toString(),
        )
        chatRoom.addUser(user)
        chatRoom.addUser(otherUser)

        return chatRoomRepository.save(chatRoom)
    }

    fun deleteChatRoom(roomId: Long) {
        val chatRoom = chatRoomRepository.findById(roomId).orElseThrow { Exception("Chat room not found") }
        chatRoomRepository.delete(chatRoom)
    }

    fun createMessageResponse(you: User, chatRoomId: String): MessagesResponse {
        val chatHistories = chatHistoryRepository.findByChatRoomId(chatRoomId)
                .map { ChatHistoryResponse.of(it) }

        return MessagesResponse(
                you = SimpleUserResponse.of(you),
                chatHistories = chatHistories
        )
    }
}
