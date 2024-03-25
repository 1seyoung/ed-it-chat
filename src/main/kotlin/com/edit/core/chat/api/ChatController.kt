package com.edit.core.chat.api

import com.edit.core.chat.api.dto.request.ReceivedChatMessage
import com.edit.core.chat.api.dto.request.SendChatMessage
import com.edit.core.chat.service.ChatService
import org.springframework.http.ResponseEntity
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/chat")
class ChatController(
        private val messagingTemplate: SimpMessagingTemplate,
        private val chatService: ChatService,
) {

    @MessageMapping("/message")
    fun handleMessage(message: ReceivedChatMessage) {
        val chatId = chatService.saveChatMessage(message.roomUUID, message.senderId, message.message)
        messagingTemplate.convertAndSend("/sub/room/${message.roomUUID}", SendChatMessage(chatId, message.roomUUID, message.senderId, message.message, message.createdAt))
    }

    @GetMapping("/{chat-id}")
    fun readMessage(@PathVariable(name = "chat-id") chatId: Long) {
        chatService.readChat(chatId)
    }

    //@PostMapping("/rooms")
    //fun createRoom(@RequestBody createRoomRequest: CreateRoomRequest): ResponseEntity<RoomResponse> {
    //    val chatRoom = chatService.createChatRoom(createRoomRequest.userId, createRoomRequest.otherUserId)
    //    return ResponseEntity.ok(RoomResponse(chatRoom.id, chatRoom.roomUUID))
    //}

    //@DeleteMapping("/rooms/{roomId}")
    //fun deleteRoom(@PathVariable roomId: Long): ResponseEntity<Void> {
    //    chatService.deleteChatRoom(roomId)
    //    return ResponseEntity.ok().build()
    //}
}
