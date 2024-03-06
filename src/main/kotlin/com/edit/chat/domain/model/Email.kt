package com.edit.chat.domain.model

// 이메일 값을 검증하는 값 객체
data class Email(val value: String) {
    init {
        require(value.contains("@") && value.contains(".")) { "Invalid email address" }
    }
}