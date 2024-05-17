package com.example.invoice.service

import ch.qos.logback.core.net.server.Client
import com.example.invoice.entity.Product
import com.example.invoice.repository.ClientRepository
import com.example.invoice.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService {
    @Autowired
    lateinit var productRepository: ProductRepository

    fun list (): List<Client> {
        return productRepository.findAll()
    }
    fun save (product: Product):Product{
        return productRepository.save (product)
    }

}