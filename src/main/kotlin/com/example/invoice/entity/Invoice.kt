package com.example.invoice.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table (name= "invoice")
class Invoice {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var code: String? = null

    @Column(name = "create_at")
    var createAt: Date? = null
    var total: Double? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    var client: Client? = null
}