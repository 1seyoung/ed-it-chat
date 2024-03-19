package com.edit.chat.controller

import com.edit.chat.service.ChatService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/chat")
class ChatController(private val chatService: ChatService) {

    @PostMapping("/leave")
    fun leaveChat(@RequestBody leaveRequest: LeaveRequest): ResponseEntity<Any> {
        val result = chatService.leaveChat(leaveRequest.username, leaveRequest.chatRoomId)
        return if (result) ResponseEntity.ok().build()
        else ResponseEntity.badRequest().body("Error leaving chat room")
    }
}


data class LeaveRequest(val username: String, val chatRoomId: Long)