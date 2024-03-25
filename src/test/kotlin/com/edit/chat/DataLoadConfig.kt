package com.edit.chat

import com.edit.core.chat.entity.ChatRoom
import com.edit.core.chat.repository.ChatRoomRepository
import com.edit.core.user.entity.User
import com.edit.core.user.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import java.util.UUID

@Configuration
class DataLoadConfig {

    @Bean
    fun initDatabase(userRepository: UserRepository,
                     chatRoomRepository: ChatRoomRepository): CommandLineRunner {
        return CommandLineRunner {
            // 사용자 생성
            val user1 = userRepository.save(User(username = "user1", email = "user1@example.com"))
            val user2 = userRepository.save(User(username = "user2", email = "user2@example.com"))

            // 채팅방 생성 및 사용자 추가
            val roomUUID = UUID.randomUUID().toString()
            val chatRoom = ChatRoom(roomUUID = roomUUID).apply {
                addUser(user1)
                addUser(user2)
            }
            chatRoomRepository.save(chatRoom)

            // 추가적으로 더 많은 테스트 데이터를 이곳에서 생성 가능
        }
    }
}
