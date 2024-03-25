package com.edit.core.chat.entity

import com.edit.core.user.entity.User
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "chat_room")
class ChatRoom(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0L,

        @Column(name = "room_uuid")
        val roomUUID: String,


        @ManyToMany(cascade = [CascadeType.ALL])
        @JoinTable(
                name = "chat_room_users",
                joinColumns = [JoinColumn(name = "chat_room_id")],
                inverseJoinColumns = [JoinColumn(name = "user_id")]
        )
        val users: MutableList<User> = mutableListOf()
) {
    // Using a custom getter for memberCount to always return the current size of the users list.
    val memberCount: Int
        get() = users.size

    companion object {
        fun create(_roomUUID: String): ChatRoom {
            return ChatRoom(
                    roomUUID = _roomUUID
            )
        }
    }

    fun addUser(user: User) {
        users.add(user)
    }

    fun removeUser(user: User) {
        users.remove(user)
    }

}
