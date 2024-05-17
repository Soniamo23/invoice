package com.example.invoice.repository

import com.example.invoice.entity.Client
import com.example.invoice.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository:JpaRepository <Client, Long?> {
    fun findById (id:Long?): Client?
}