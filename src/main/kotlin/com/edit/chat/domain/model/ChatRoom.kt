package com.edit.chat.domain.model

import java.time.Instant
import java.util.UUID
// 채팅방을 나타내는 엔티티
data class ChatRoom(
    val id: UUID = UUID.randomUUID(),
    var name: String,
    val created: Instant = Instant.now(),
    val participants: MutableSet<Student> = mutableSetOf()
)