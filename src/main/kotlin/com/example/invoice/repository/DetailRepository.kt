package com.example.invoice.repository

import com.example.invoice.entity.Detail
import org.springframework.data.jpa.repository.JpaRepository

interface DetailRepository:JpaRepository<Detail, Long?> {

}