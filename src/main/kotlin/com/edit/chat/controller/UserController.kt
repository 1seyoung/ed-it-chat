package com.edit.chat.controller

import com.edit.chat.model.User
import com.edit.chat.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @PostMapping
    fun registerUser(@RequestBody user: User): ResponseEntity<User> {
        val registeredUser = userService.registerUser(user)
        return ResponseEntity.ok(registeredUser)
    }

    @PostMapping("/auth/login")
    fun loginUser(@RequestBody credentials: Map<String, String>): ResponseEntity<String> {
        val token = userService.loginUser(credentials["username"]!!, credentials["password"]!!)
        return ResponseEntity.ok(token)
    }

    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: Long): ResponseEntity<User> {
        val user = userService.getUserById(userId)
        return ResponseEntity.ok(user)
    }
}
