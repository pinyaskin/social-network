package com.pinyaskin.social.repositories

import com.pinyaskin.social.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository : JpaRepository<User, Long> {
    fun getUserById(id: Long): Optional<User>
}