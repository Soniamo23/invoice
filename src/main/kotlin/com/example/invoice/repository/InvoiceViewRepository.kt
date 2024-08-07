package com.example.invoice.repository

import com.example.invoice.entity.InvoiceView
import org.springframework.data.jpa.repository.JpaRepository

import org.springframework.stereotype.Repository

@Repository
interface InvoiceViewRepository:JpaRepository <InvoiceView, Long?> {

}