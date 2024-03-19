package com.edit.core.chat.service

import com.edit.core.chat.model.User
import com.edit.core.chat.repo.UserRepository
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicLong


@Service
class UserService(private val userRepository: UserRepository) {
    private val users = ConcurrentHashMap<Long, User>() //메모리 디비 사용
    private val userIdSequence = AtomicLong(0)

    fun registerUser(user: User): User {
        val id = userIdSequence.incrementAndGet()
        val newUser = user.copy(userid = id)
        users[id] = newUser
        return newUser
    }

    fun loginUser(username: String, password: String): String {
        val user = users.values.find { it.username == username && it.password == password }
        return if (user != null) "fake-token-${user.userid}" else throw IllegalArgumentException("Invalid username or password")
    }

    fun getUserById(userId: Long): User {
        return users[userId] ?: throw NoSuchElementException("User not found")
    }

    fun joinChatRoom(userId: Long, chatRoomId: Long) {
        users[userId]?.let {
            it.chatRoomId = chatRoomId
        } ?: throw NoSuchElementException("User not found")
    }

    fun leaveChatRoom(userId: Long) {
        users[userId]?.let {
            it.chatRoomId = null
        } ?: throw NoSuchElementException("User not found")
    }

    // 사용자 이름으로 사용자 찾기
    fun findUserByUsername(username: String): User? {
        return users.values.find { it.username == username }
    }
}