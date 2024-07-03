package com.example.invoice.service

import com.example.invoice.entity.Detail
import com.example.invoice.repository.DetailRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DetailService {
    @Autowired
    private lateinit var detailRepository: DetailRepository

    fun list (): List<Detail>{
        return detailRepository.findAll()
    }
    fun getById(id: Long) :Detail {
        return detailRepository.findById(id).orElseThrow{ RuntimeException("Detail not found!") }
    }
    fun save (detail: Detail): Detail {
        return detailRepository.save(detail)
    }
    fun update(id: Long, detail: Detail):Detail{
        val existingDetail = detailRepository.findById(id).orElseThrow { RuntimeException("detail not found") }
        existingDetail.quantity = detail.quantity
        existingDetail.price = detail.price
        existingDetail.subTotal = detail.subTotal
        existingDetail.invoice = detail.invoice
        existingDetail.product = detail.product
        return detailRepository.save(existingDetail)
    }
    fun delete(id:Long){
        if (detailRepository.existsById(id)){
            detailRepository.deleteById(id)
        }else{
            throw RuntimeException("detail not found")
        }
    }
    fun validateQuantity(quantity: Int): Boolean {
        return quantity > 0
    }

    fun main() {

        val productQuantity = 5

        if (validateQuantity(productQuantity)) {
            println("The quantity is valid.")
        } else {
            println("The quantity is not valid.")
        }
    }



}