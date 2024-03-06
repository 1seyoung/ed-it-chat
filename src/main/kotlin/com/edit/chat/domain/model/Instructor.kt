package com.edit.chat.domain.model

import java.util.UUID

data class Instructor(
    val id: UUID = UUID.randomUUID(),
    var name: String,
    var email: Email
)
