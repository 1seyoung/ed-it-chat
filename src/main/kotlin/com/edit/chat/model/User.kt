package com.edit.chat.model

import jakarta.persistence.*
import java.time.LocalDateTime


/**
 * 사용자 정보를 나타내는 엔티티 클래스.
 *
 * @property id 사용자의 고유 식별자.
 * @property username 사용자의 유니크한 사용자 이름.
 * @property email 사용자의 이메일 주소.
 */
@Entity
@Table(name = "users")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    val username: String,

    @Column(nullable = false)
    val password: String,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = true)
    val displayName: String?,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinTable(
        name = "user_chatrooms",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "chatroom_id")]
    )
    val chatrooms: MutableSet<Chatroom> = mutableSetOf()
)
