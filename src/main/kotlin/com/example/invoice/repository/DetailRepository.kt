package com.example.invoice.repository

import com.example.invoice.entity.Client
import com.example.invoice.entity.Detail
import com.example.invoice.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface DetailRepository:JpaRepository <Detail, Long?> {
    fun findById (id:Long?): Detail?
}