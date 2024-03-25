package com.edit.core.chat.api.dto.respone

import com.edit.core.chat.entity.ChatHistory
import com.edit.core.user.api.dto.response.SimpleUserResponse
import com.edit.core.user.entity.User
import java.time.LocalDateTime

data class MessagesResponse(
        val you: SimpleUserResponse,
        val chatHistories: List<ChatHistoryResponse>
) {
    companion object {
        fun of(you: User, chatHistories: List<ChatHistory>): MessagesResponse {
            return MessagesResponse(
                    you = SimpleUserResponse.of(you),
                    chatHistories = chatHistories.map { ChatHistoryResponse.of(it) }
            )
        }
    }
}


data class ChatHistoryResponse(
        val senderId: Long,
        val message: String,
        val createdAt: LocalDateTime,
) {
    companion object {
        fun of(chatHistory: ChatHistory): ChatHistoryResponse {
            return ChatHistoryResponse(
                    senderId = chatHistory.senderId.toLong(), // 문자열 senderId를 Long으로 변환
                    message = chatHistory.message,
                    createdAt = chatHistory.createdAt,
            )
        }
    }
}
