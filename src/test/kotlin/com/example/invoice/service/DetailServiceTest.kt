package com.example.invoice.service

import com.example.invoice.entity.Client
import com.example.invoice.entity.Detail
import com.example.invoice.repository.ClientRepository
import com.example.invoice.repository.DetailRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class DetailServiceTest {

    @InjectMocks
    lateinit var detailService: DetailService

    @Mock
    lateinit var detailRepository: DetailRepository

    val jsonString = File("./src/test/resources/Detail/newDetail.json").readText(Charsets.UTF_8)
    val detailMock = Gson().fromJson(jsonString, Detail::class.java)

    @Test
    fun saveWhenDetailIsCorrect() {
        Mockito.`when`(detailRepository.save(Mockito.any(Detail::class.java))).thenReturn(detailMock)
        val response = detailService.save(detailMock)
        Assertions.assertEquals(response.quantity, detailMock.quantity)

    }
}