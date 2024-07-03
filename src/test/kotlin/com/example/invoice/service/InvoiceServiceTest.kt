package com.example.invoice.service

import com.example.invoice.entity.Client
import com.example.invoice.entity.Invoice
import com.example.invoice.repository.InvoiceRepository
import com.example.invoice.repository.InvoiceViewRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class InvoiceServiceTest {
    @Mock
    lateinit var invoiceRepository: InvoiceRepository

    @Mock
    lateinit var invoiceViewRepository: InvoiceViewRepository

    @InjectMocks
    lateinit var invoiceService: InvoiceService

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    val jsonString = File("./src/test/resources/Invoice/newInvoice.json").readText(Charsets.UTF_8)
    val invoiceMock = Gson().fromJson(jsonString, Invoice::class.java)
    @Test
    fun saveWhenInvoiceCodeIsCorrect() {
        Mockito.`when`(invoiceRepository.save(Mockito.any(Invoice::class.java))).thenReturn(invoiceMock)
        val response = invoiceService.save(invoiceMock)
        Assertions.assertEquals(response.code, invoiceMock.code)
    }
    @Test
    fun saveWhenNiuClientIsIncorrect() {
        invoiceMock.code = "1589563244"
        Mockito.`when`(invoiceRepository.save(Mockito.any(Invoice::class.java))).thenReturn(invoiceMock)

        val response = invoiceService.validateInvoiceCode(invoiceMock.code!!)
        Assertions.assertEquals(false, response)
    }
    @Test
    fun validateInvoiceCode_ValidCode_ReturnsTrue() {
        val isValid = invoiceService.validateInvoiceCode("001-001-000000001")
        Assertions.assertTrue(isValid)
    }

}
