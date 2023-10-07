package com.pinyaskin.social.services

import com.pinyaskin.social.entities.User
import com.pinyaskin.social.repositories.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun getUserById(id: Long): Optional<User> {
        return userRepository.getUserById(id)
    }

    fun save(user: User): User {
        user.password = passwordEncoder.encode(user.password)
        return userRepository.save(user);
    }
}
