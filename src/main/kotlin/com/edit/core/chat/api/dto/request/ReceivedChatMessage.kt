package com.edit.core.chat.api.dto.request

import java.time.LocalDateTime

data class ReceivedChatMessage(
        val roomUUID: String,
        val senderId: Long,
        val message: String,
        val createdAt: LocalDateTime,
)