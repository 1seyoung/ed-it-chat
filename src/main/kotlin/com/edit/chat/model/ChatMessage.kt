package com.edit.chat.model

data class ChatMessage(
        val roomId: String,
        val sender: String,
        val content: String
)