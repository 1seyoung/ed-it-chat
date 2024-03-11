package com.edit.chat.model

import com.edit.chat.model.User
import jakarta.persistence.*
import java.time.LocalDateTime
/**
 * 채팅방을 나타내는 엔티티 클래스입니다.
 *
 * @property id 채팅방의 고유 식별자입니다. 자동으로 생성됩니다.
 * @property name 채팅방의 이름입니다. 고유해야 합니다.
 * @property description 채팅방에 대한 설명입니다. 선택적으로 제공됩니다.
 * @property createdAt 채팅방이 생성된 날짜 및 시간입니다. 기본값으로 현재 시간을 사용합니다.
 * @property users 이 채팅방에 속한 사용자들의 집합입니다. [User] 모델과의 다대다 관계를 설정합니다.
 *                 여기서 `mappedBy` 속성은 [User] 측에서 이미 정의한 연결 필드(`chatrooms`)를 참조합니다.
 */
@Entity
@Table(name = "chatrooms")
data class Chatroom(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    val name: String,

    @Column(nullable = true)
    val description: String? = null,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @ManyToMany(mappedBy = "chatrooms")
    val users: MutableSet<User> = mutableSetOf()
)