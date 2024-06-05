package com.example.invoice.controller

import com.example.invoice.entity.Detail
import com.example.invoice.service.DetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping
class DetailController {
    @Autowired
    lateinit var detailService: DetailService

    @GetMapping
    fun list(): List<Detail> {
        return  detailService.list()

    }
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Detail {
        return detailService.getById(id)
    }
    @PostMapping
    fun save(@RequestBody detail: Detail): Detail {
        return detailService.save(detail)
    }
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody detail: Detail): Detail {
        return detailService.update(id, detail)
    }
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:Long):String {
        detailService.delete(id)
        return "Detail $id deleted"
    }
}
