package com.edit.core.chat.repository

import com.edit.core.chat.entity.ChatRoom


//사용자 ID에 따라 채팅방과 관련된 모든 정보를 가져오는 목적
// ChatRoomCustomRepository.kt
interface ChatRoomCustomRepository {
    fun someCustomMethodToFindChatRoom(userId: Long): List<ChatRoom>
}

// ChatRoomRepositoryImpl.kt
class ChatRoomRepositoryImpl : ChatRoomCustomRepository {
    override fun someCustomMethodToFindChatRoom(userId: Long): List<ChatRoom> {
        // 여기에서 커스텀 쿼리 로직 구현
        return emptyList() //TODO : 커스텀 쿼리 로직 구현
    }
}
