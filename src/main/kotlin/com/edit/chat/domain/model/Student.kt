package com.edit.chat.domain.model

import java.time.Instant
import java.util.UUID

// 학생을 나타내는 엔티티
data class Student(
    val id: UUID = UUID.randomUUID(),
    var name: String,
    var email: Email // Email은 값을 검증하는 값 객체입니다.
)