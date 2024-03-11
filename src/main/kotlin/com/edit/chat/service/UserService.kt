package com.edit.chat.service

import com.edit.chat.model.User
import com.edit.chat.repository.UserRepository

class UserService(private val userRepository: UserRepository) {

    suspend fun getUser(username: String): User? = userRepository.findByUsername(username)
}