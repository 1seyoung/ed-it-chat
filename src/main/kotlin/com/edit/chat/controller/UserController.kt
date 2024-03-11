package com.edit.chat.controller

import com.edit.chat.model.User
import com.edit.chat.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(private val userService: UserService) {

    @GetMapping("/user/{username}")
    suspend fun getUser(@PathVariable username: String): ResponseEntity<User> {
        val user = userService.getUser(username) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(user)
    }
}