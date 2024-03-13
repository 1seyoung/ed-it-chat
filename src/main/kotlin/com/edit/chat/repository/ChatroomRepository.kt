package com.edit.chat.repository


import com.edit.chat.model.Chatroom
import org.springframework.data.jpa.repository.JpaRepository

interface ChatroomRepository: JpaRepository<Chatroom, Long> {
    // 필요한 추가 메소드 정의 가능
}
