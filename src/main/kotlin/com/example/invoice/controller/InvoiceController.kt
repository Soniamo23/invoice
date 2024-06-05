package com.example.invoice.controller

import com.example.invoice.entity.Invoice
import com.example.invoice.entity.InvoiceView
import com.example.invoice.service.InvoiceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/invoices")
class InvoiceController {
    @Autowired
    lateinit var invoiceService: InvoiceService

    @GetMapping
    fun list(): List<Invoice> {
        return  invoiceService.list()

    }

    @GetMapping("/with-client")
    fun listView(): List<InvoiceView> {
        return  invoiceService.listView()

    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Invoice {
        return invoiceService.getById(id)
    }
    @GetMapping("/{value}/get-total")
    fun getTotal(@PathVariable value: Double):List<Invoice>{
        return invoiceService.getTotal(value)
    }
    @PostMapping
    fun save(@RequestBody  invoice: Invoice): Invoice {
        return invoiceService.save(invoice)
    }
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody invoice: Invoice): Invoice {
        return invoiceService.update(id, invoice)
    }
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:Long):String {
        invoiceService.delete(id)
        return "Client $id deleted"
    }
}
