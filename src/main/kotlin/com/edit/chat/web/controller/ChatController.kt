package com.edit.chat.web.controller

// 파일 경로: src/main/kotlin/com/edit/chat/web/controller/ChatController.kt


import com.edit.chat.domain.model.Message
import com.edit.chat.domain.model.MessageType
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    fun sendMessage(message: Message): Message {
        // TODO: 메시지 저장 로직 추가 (예: 데이터베이스 저장)
        return message
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    fun addUser(message: Message): Message {
        // TODO: 채팅방에 새로운 사용자가 참여했음을 처리하는 로직 추가
        if (message.type == MessageType.JOIN) {
            // 새로운 참여자를 처리하는 로직을 구현합니다.
            // 예: 채팅방의 참여자 목록 업데이트
        }
        return message
    }
}
