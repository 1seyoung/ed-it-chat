package com.edit.chat.domain.model

import java.time.Instant
import java.util.UUID




// 메시지를 나타내는 엔티티
data class Message(
    val id: UUID = UUID.randomUUID(),      // 메시지 고유 ID
    val chatRoomId: UUID,                  // 메시지가 속한 채팅방 ID
    val senderId: UUID,                    // 메시지를 보낸 사용자 ID
    val type: MessageType,                 // 메시지 유형
    val content: String,                   // 메시지 내용
    val timestamp: Instant = Instant.now() // 메시지가 보내진 시간
)

// 메시지 유형을 나타내는 열거형
enum class MessageType {
    CHAT,    // 일반 채팅 메시지
    JOIN,    // 사용자가 채팅방에 참여하였음을 나타냄
    LEAVE    // 사용자가 채팅방을 떠났음을 나타냄
}
