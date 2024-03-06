package com.edit.chat.domain.model

import java.util.UUID

data class Class(
    val id: UUID = UUID.randomUUID(),
    var title: String,
    var description: String? = null,
    var instructor: Instructor // 수업을 담당하는 교수자
)