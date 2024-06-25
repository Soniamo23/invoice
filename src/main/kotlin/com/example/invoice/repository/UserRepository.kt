package com.example.invoice.repository

import com.example.invoice.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository:JpaRepository <User, Long?> {
    fun findByUsername(username: String): User?

}