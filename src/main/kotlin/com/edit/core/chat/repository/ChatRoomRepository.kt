package com.edit.core.chat.repository

import com.edit.core.chat.entity.ChatRoom
import com.edit.core.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface ChatRoomRepository : JpaRepository<ChatRoom, Long>, ChatRoomCustomRepository {
    fun findChatRoomByRoomUUID(roomUUID: String): ChatRoom?
    // 필요에 따라 다른 메서드 추가 가능
}