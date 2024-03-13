package com.edit.chat.service

import com.edit.chat.model.User
import com.edit.chat.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService {
    fun registerUser(user: User): User {
        // 사용자 등록 로직 구현

    }

    fun loginUser(username: String, password: String): String {
        // 로그인 로직 구현 및 토큰 반환
    }

    fun getUserById(userId: Long): User {
        // 사용자 정보 조회 로직 구현

    }
}