package com.edit.chat.domain.model

import java.util.UUID


// 프로젝트를 나타내는 엔티티
data class Project(
    val id: UUID = UUID.randomUUID(),
    val teamId: UUID,
    var title: String,
    var description: String? = null
)
