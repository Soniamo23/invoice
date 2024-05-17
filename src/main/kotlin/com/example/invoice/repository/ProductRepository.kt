package com.example.invoice.repository

import com.example.invoice.entity.Product
import org.springframework.data.jpa.repository.JpaRepository


interface ProductRepository:JpaRepository<Product, Long?> {
    fun findById (id:Long?):Product?
}