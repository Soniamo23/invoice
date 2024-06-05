package com.example.invoice.controller

import com.example.invoice.entity.Client
import com.example.invoice.service.ClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/client")
class ClientController {
    @Autowired
    lateinit var clientService: ClientService

    @GetMapping
    fun list(): List<Client> {
        return  clientService.list()

    }
    @GetMapping("/{id}")
    fun getById(@PathVariable id : Long): Client {
        return clientService.getById(id)
    }
    @PostMapping
    fun save(@RequestBody  client: Client):Client {
        return clientService.save(client)
    }
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long,@RequestBody client: Client):Client {
        return clientService.update(id, client)
    }
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:Long):String {
        clientService.delete(id)
        return "Client $id deleted"
    }
}
