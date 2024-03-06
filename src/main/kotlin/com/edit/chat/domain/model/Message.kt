package com.edit.chat.domain.model

import java.time.Instant
import java.util.UUID


// 메시지를 나타내는 엔티티
data class Message(
    val id: UUID = UUID.randomUUID(),
    val chatRoomId: UUID,
    val senderId: UUID, // 메시지를 보낸 학생의 ID
    val content: String,
    val timestamp: Instant = Instant.now() // 메시지가 보내진 시간
)