package com.example.invoice.repository

import com.example.invoice.entity.Client
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository:JpaRepository <Client, Long?> {

}