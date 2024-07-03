package com.example.invoice.service

import com.example.invoice.entity.Client
import com.example.invoice.entity.Invoice
import com.example.invoice.entity.Product
import com.example.invoice.repository.ClientRepository
import com.example.invoice.repository.InvoiceRepository
import com.example.invoice.repository.InvoiceViewRepository
import com.example.invoice.repository.ProductRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class ProductServiceTest {


    @InjectMocks
    lateinit var productService: ProductService

    @Mock
    lateinit var productRepository: ProductRepository

    val jsonString = File("./src/test/resources/Product/newProduct.json").readText(Charsets.UTF_8)
    val productMock = Gson().fromJson(jsonString, Product::class.java)

    @Test
    fun saveWhenProductIsCorrect() {
        Mockito.`when`(productRepository.save(Mockito.any(Product::class.java))).thenReturn(productMock)
        val response = productService.save(productMock)
        Assertions.assertEquals(response.stock, productMock.stock)

    }



}
