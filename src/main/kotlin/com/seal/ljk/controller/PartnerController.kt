package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.Partner
import com.seal.ljk.service.PartnerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/partner")
class PartnerController {

    @Autowired
    lateinit var partnerService: PartnerService

    @GetMapping("/all")
    fun getAllPartner(): ResVal {
        try {
            partnerService.getAllPartner()
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, partnerService.getAllPartner())
    }

    @RequestMapping("/add")
    fun createPartner(@RequestBody partner: Partner): ResVal {
        try {
            partnerService.createPartner(partner)
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    @GetMapping("/delete")
    fun deletePartnerById(@RequestParam partnerId: String): ResVal {
        try {
            partnerService.deletePartnerById(partnerId)
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    @RequestMapping("/update")
    fun updatePartnerById(@RequestBody partner: Partner): ResVal {
        try {
            partnerService.updatePartnerById(partner)
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    @GetMapping("/getById")
    fun getPartnerById(@RequestParam partnerId: String): ResVal {
        try {
            partnerService.getPartnerById(partnerId)
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, partnerService.getPartnerById(partnerId))
    }

    @GetMapping("/list")
    fun getPartnerList(@RequestParam currentPage: Int, @RequestParam pageSize: Int): ResVal {
        val currentPageNew = (currentPage - 1) * pageSize
        try {
            partnerService.getPartnerList(currentPageNew, pageSize)
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, partnerService.getPartnerList(currentPageNew, pageSize))
    }

}