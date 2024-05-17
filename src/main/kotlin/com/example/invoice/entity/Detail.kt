package com.example.invoice.entity

import jakarta.persistence.*


@Entity
@Table(name = "detail")
class Detail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var quantity: Long? = null
    var price: Double? = null
    var subtotal: Double? = null
    var invoiceId: Long? = null
    var productId: Long? = null
}