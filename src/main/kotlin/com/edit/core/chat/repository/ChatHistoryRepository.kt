package com.edit.core.chat.repository

import com.edit.core.chat.entity.ChatHistory
import org.springframework.data.mongodb.repository.MongoRepository
import java.time.LocalDateTime

interface ChatHistoryRepository : MongoRepository<ChatHistory, String>{

    fun findByChatRoomId(chatRoomId: String): List<ChatHistory>

}
