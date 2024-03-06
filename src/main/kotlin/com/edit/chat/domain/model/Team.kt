package com.edit.chat.domain.model

import java.util.UUID

// 프로젝트 팀을 나타내는 엔티티
data class Team(
    val id: UUID = UUID.randomUUID(),
    val classId: UUID,
    var name: String,
    val members: MutableSet<Student> = mutableSetOf(), // 팀 구성원
    val chatRoom: ChatRoom // 해당 팀 전용 채팅방
)
