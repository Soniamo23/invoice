package com.example.invoice.service

import com.example.invoice.entity.Product
import com.example.invoice.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService{
    @Autowired
    private lateinit var productRepository: ProductRepository

    fun list (): List<Product>{
        return productRepository.findAll()
    }
    fun getById(id: Long) : Product {
        return productRepository.findById(id).orElseThrow{ RuntimeException("Product not found!") }
    }
    fun save (product: Product): Product {
        return productRepository.save(product)
    }
    fun update(id: Long, product: Product): Product {
        val existingProduct = productRepository.findById(id).orElseThrow { RuntimeException("product not found") }
        existingProduct.description = product.description
        existingProduct.brand = product.brand
        existingProduct.price = product.price
        return productRepository.save(existingProduct)
    }
    fun delete(id:Long){
        if (productRepository.existsById(id)){
            productRepository.deleteById(id)
        }else{
            throw RuntimeException("product not found")
        }
    }
}