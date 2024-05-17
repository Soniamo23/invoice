package com.example.invoice.repository

import com.example.invoice.entity.Client
import com.example.invoice.entity.Invoice
import com.example.invoice.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface InvoiceRepository:JpaRepository <Invoice, Long?> {
    fun findByid (id:Long): Invoice?
}