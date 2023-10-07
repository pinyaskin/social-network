package com.pinyaskin.social.controllers

import com.pinyaskin.social.entities.User
import com.pinyaskin.social.requests.AddUserRequest
import com.pinyaskin.social.requests.EditUserRequest
import com.pinyaskin.social.services.UserService
import org.modelmapper.ModelMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService,
    // private val mapper: ModelMapper
) {
    @GetMapping("/{id}")
    fun getUserById(@PathVariable("id") id: Long): ResponseEntity<Any> {
        val userOptional: Optional<User> = userService.getUserById(id)
        if (userOptional.isEmpty) return ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        return ResponseEntity.ok().build()
    }

    @PostMapping("/add")
    fun createNewUser(@RequestBody request: AddUserRequest): ResponseEntity<Any> {
        val user: User
        try {
            user = User.builder()
                .username(request.username)
                .password(request.password)
                .build()
        } catch (e: Exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user))
    }

//    @PutMapping("/{id}")
//    fun editUser(@RequestBody request: EditUserRequest) {
//
//    }
}