package com.example.invoice.service


import com.example.invoice.entity.Client
import com.example.invoice.repository.ClientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClientService {
    @Autowired
    private lateinit var clientRepository: ClientRepository

    fun list (): List<Client>{
        return clientRepository.findAll()
    }
    fun getById(id: Long) : Client{
        return clientRepository.findById(id).orElseThrow{ RuntimeException("Client not found!") }
    }
    fun save (client:Client):Client{

        return clientRepository.save(client)
    }

    fun update(id: Long, client:Client):Client {
        val existingClient = clientRepository.findById(id).orElseThrow { RuntimeException("client not found") }
        existingClient.nui = client.nui
        existingClient.fullName = client.fullName
        existingClient.email = client.email
        return clientRepository.save(existingClient)
    }
    fun delete(id:Long){
        if (clientRepository.existsById(id)){
            clientRepository.deleteById(id)
        }else{
            throw RuntimeException("client not found")
        }
    }

    fun validateNui(nui: String?): Boolean {
        if (nui == null || nui.length != 10 || !nui.all { it.isDigit() }) {
            return false
        }

        val province = nui.substring(0, 2).toInt()
        if (province < 1 || province > 24) {
            return false
        }

        val thirdDigit = nui[2].toString().toInt()
        if (thirdDigit < 0 || thirdDigit > 5) {
            return false
        }

        val verificationDigit = nui.last().toString().toInt()
        var sum = 0

        for (i in 0..8) {
            val digit = nui[i].toString().toInt()
            if (i % 2 == 0) {
                var product = digit * 2
                if (product > 9) {
                    product -= 9
                }
                sum += product
            } else {
                sum += digit
            }
        }

        val calculatedVerifier = if (sum % 10 == 0) 0 else 10 - (sum % 10)

        return calculatedVerifier == verificationDigit
    }
}
