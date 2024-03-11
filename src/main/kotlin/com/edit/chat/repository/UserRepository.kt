package com.edit.chat.repository

import com.edit.chat.model.User
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface UserRepository: CoroutineCrudRepository<User, Long> {
    suspend fun findByUsername(username: String): User?
}