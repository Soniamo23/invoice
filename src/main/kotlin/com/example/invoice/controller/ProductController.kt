package com.example.invoice.controller

import com.example.invoice.entity.Product
import com.example.invoice.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/product")
class ProductController {
    @Autowired
    lateinit var productService: ProductService

    @GetMapping
    fun list(): List<Product> {
        return  productService.list()

    }
    @GetMapping("/{id}")
    fun getById(@PathVariable id : Long): Product {
        return productService.getById(id)
    }
    @PostMapping
    fun save(@RequestBody  product: Product): Product {
        return productService.save(product)
    }
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody product: Product): Product {
        return productService.update(id, product)
    }
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:Long):String {
        productService.delete(id)
        return "Product $id deleted"
    }
}
