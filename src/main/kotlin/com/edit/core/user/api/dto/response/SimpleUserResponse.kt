package com.edit.core.user.api.dto.response

import com.edit.core.user.entity.User

//simple user response : id, username,email
//SimpleUserResponse 데이터 클래스는 사용자에 대한 간략한 정보를 전달하기 위한 DTO(Data Transfer Object)
data class SimpleUserResponse(
        val id: Long,
        val username: String,
        val email: String
) {
    companion object {
        fun of(user: User): SimpleUserResponse {
            return SimpleUserResponse(
                    id = user.id,
                    username = user.username,
                    email = user.email
            )
        }
    }
}

