package com.example.invoice.service


import com.example.invoice.entity.Invoice
import com.example.invoice.entity.InvoiceView
import com.example.invoice.repository.InvoiceRepository
import com.example.invoice.repository.InvoiceViewRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class InvoiceService {
    @Autowired
    lateinit var invoiceRepository: InvoiceRepository

    @Autowired
    lateinit var invoiceViewRepository: InvoiceViewRepository

    fun list (): List<Invoice>{
        return invoiceRepository.findAll()
    }

    fun listView(): List<InvoiceView>{
        return invoiceViewRepository.findAll()
    }

    fun getById(id: Long) : Invoice{
        return invoiceRepository.findById(id).orElseThrow{ RuntimeException("Invoice not found!") }
    }
    fun getTotal (value:Double):List<Invoice>{
        return invoiceRepository.findTotal(value)
    }
    fun save (invoice: Invoice): Invoice {
        return invoiceRepository.save(invoice)
    }
    fun update(id: Long, invoice: Invoice): Invoice {
        val existingInvoice = invoiceRepository.findById(id).orElseThrow { RuntimeException("invoice not found") }
        existingInvoice.code = invoice.code
        existingInvoice.createAt = invoice.createAt
        existingInvoice.total = invoice.total
        return invoiceRepository.save(existingInvoice)
    }
    fun delete(id:Long){
        if (invoiceRepository.existsById(id)){
            invoiceRepository.deleteById(id)
        }else{
            throw RuntimeException("invoice not found")
        }
    }
}