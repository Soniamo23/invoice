package com.example.invoice.service

import com.example.invoice.entity.Client
import com.example.invoice.entity.Invoice
import com.example.invoice.repository.ClientRepository
import com.example.invoice.repository.InvoiceRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class ClientServiceTest {


    @InjectMocks
    lateinit var clientService: ClientService

    @Mock
    lateinit var clientRepository: ClientRepository

    val jsonString = File("./src/test/resources/Client/newClient.json").readText(Charsets.UTF_8)
    val clientMock = Gson().fromJson(jsonString, Client::class.java)

    @Test
    fun saveWhenClientIsCorrect() {
        Mockito.`when`(clientRepository.save(Mockito.any(Client::class.java))).thenReturn(clientMock)
        val response = clientService.save(clientMock)
        Assertions.assertEquals(response.id, clientMock.id)

    }
    @Test
    fun saveWhenNiuClientIsIncorrect() {
        clientMock.nui= "1563244"
        Mockito.`when`(clientRepository.save(Mockito.any(Client::class.java))).thenReturn(clientMock)
        val response = clientService.validateNui(clientMock.nui)
        Assertions.assertEquals(false,response)
    }

}