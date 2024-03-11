package com.edit.chat.model

import java.time.LocalDateTime
import jakarta.persistence.*

/**
 * 채팅 시스템에서 사용자 간의 메시지를 나타내는 엔티티 클래스입니다.
 * 메시지는 텍스트, 이미지, 파일 등 다양한 유형을 포함할 수 있으며,
 * 메시지 타입은 [MessageType] 열거형을 통해 구분됩니다.
 *
 * @property id 메시지의 고유 식별자입니다. 자동으로 생성됩니다.
 * @property sentAt 메시지가 보내진 시간입니다. 기본값으로 메시지 생성 시간을 사용합니다.
 * @property sender 메시지를 보낸 사용자입니다. [User] 엔티티와 ManyToOne 관계를 맺습니다.
 * @property content 메시지의 내용입니다. 텍스트 메시지는 직접적인 내용을,
 *                   이미지나 파일의 경우는 URL이나 파일 경로를 저장할 수 있습니다.
 * @property messageType 메시지의 유형을 나타냅니다. 텍스트, 이미지, 파일 중 하나가 될 수 있습니다.
 * @property chatroom 메시지가 속한 채팅방입니다. [Chatroom] 엔티티와 ManyToOne 관계를 맺습니다.
 * @property tags 메시지와 관련된 태그들의 집합입니다. 메시지를 분류하거나 검색할 때 사용할 수 있습니다.
 */
@Entity
@Table(name = "messages")
data class Message(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val sentAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", nullable = false)
    val sender: User,

    @Column(nullable = false)
    val content: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val messageType: MessageType,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chatroom_id", nullable = false)
    val chatroom: Chatroom,

    @ElementCollection
    @CollectionTable(name = "message_tags", joinColumns = [JoinColumn(name = "message_id")])
    @Column(name = "tag")
    val tags: Set<String> = setOf()
)

/**
 * 메시지의 유형을 정의하는 열거형입니다.
 * 메시지는 TEXT, IMAGE, FILE 중 하나의 유형을 가집니다.
 */
enum class MessageType {
    TEXT, IMAGE, FILE
}