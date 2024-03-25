package com.edit.core.chat.entity

import com.edit.core.user.entity.User
import jakarta.persistence.*
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.repository.MongoRepository
import java.time.LocalDateTime

//TODO : ChatHistory Entity readCount 기능 구현
@Document(collection = "chat_history")
class ChatHistory(
        @Id
        val id: String? = null,

        val chatRoomId: String,

        val senderId: String,
        val message: String,
        //var readCount: Int = 0, // 기본값을 0으로 설정
        val createdAt: LocalDateTime = LocalDateTime.now()
)

fun createChatHistory(chatRoomId: String, senderId: String, message: String): ChatHistory {
    return ChatHistory(
            chatRoomId = chatRoomId,
            senderId = senderId,
            message = message,
            //readCount = memberCount, // ChatRoom 멤버 수로 초기화
            createdAt = LocalDateTime.now()
    )
}


// Path: src/main/kotlin/com/edit/core/chat/api/dto/request/ReceivedChatMessage.kt