package com.edit.core.user.entity

import com.edit.core.user.api.dto.response.SimpleUserResponse
import jakarta.persistence.Entity
import jakarta.persistence.*

@Entity
@Table(name = "users")
class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0, // ID가 자동으로 생성되도록 설정

        @Column(unique = true, nullable = false)
        var username: String,

        @Column(unique = true, nullable = false)
        var email: String
) {
    // 기본 생성자를 추가하여 JPA 사용 시 필요한 생성자를 추가합니다.
    constructor() : this(
            username = "",
            email = ""
    )

    // 사용자 정보를 간략하게 표현하기 위한 DTO(Data Transfer Object)를 반환하는 메서드
    fun toSimpleUserResponse(): SimpleUserResponse {
        return SimpleUserResponse(
                id = id,
                username = username,
                email = email
        )
    }
}