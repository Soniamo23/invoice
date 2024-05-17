package com.example.invoice.controller

import com.example.invoice.entity.Client
import com.example.invoice.service.ClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/client")
class ClientController {
    @Autowired
    lateinit var clientService: ClientService

    @GetMapping
    fun list(): List<ch.qos.logback.core.net.server.Client> {
        var list = clientService.list()
        return list
    }
    @PostMapping
    fun save(@RequestBody  client: Client):Client {
        return clientService.save(client)
    }
}
