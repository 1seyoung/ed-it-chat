package com.edit.core.chat.repo

//TODO: User 메모리 DB(현재) > 기능 테스트 이후 레포 연결

import com.edit.core.chat.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
}
