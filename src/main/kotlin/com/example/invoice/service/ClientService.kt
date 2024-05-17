package com.example.invoice.service

import ch.qos.logback.core.net.server.Client
import com.example.invoice.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClientService {
    @Autowired
    lateinit var clientRepository: ClientRepository

    fun list (): List<Client>{
        return clientRepository.findAll()
    }
    fun save (client: Client):Client{
        return clientRepository.save(client)
    }

}