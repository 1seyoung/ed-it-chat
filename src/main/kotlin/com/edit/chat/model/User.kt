package com.edit.chat.model

import jakarta.persistence.*
import java.time.LocalDateTime


/**
 * 사용자 정보를 나타내는 엔티티 클래스.
 *
 * @property id 사용자의 고유 식별자.
 * @property username 사용자의 유니크한 사용자 이름.
 */
@Entity
data class User(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val userid: Long? = null,
        val username: String,
        val password: String,
        var chatRoomId: Long? = null // 사용자가 현재 속한 채팅방 ID
)