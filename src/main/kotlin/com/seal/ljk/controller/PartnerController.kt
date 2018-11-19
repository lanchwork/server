package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.dao.PartnerDao
import com.seal.ljk.model.CompanyInfo
import com.seal.ljk.model.Partner
import com.seal.ljk.service.PartnerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/partner")
class PartnerController {

    @Autowired
    lateinit var partnerDao: PartnerDao
    @Autowired
    lateinit var partnerService: PartnerService

    @GetMapping("/all")
    fun getAllPartner(): ResVal {
        try {
            partnerDao.getAllPartner()
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, partnerDao.getAllPartner())
    }

    @RequestMapping("/add")
    fun createPartner(@RequestBody partner: Partner): ResVal {
        try {
            partnerDao.createPartner(partner)
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    @GetMapping("/delete")
    fun deletePartnerById(@RequestParam partnerId: String): ResVal {
        try {
            partnerDao.deletePartnerById(partnerId)
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    @RequestMapping("/update")
    fun updatePartnerById(@RequestBody partner: Partner): ResVal {
        try {
            partnerDao.updatePartnerById(partner)
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    @GetMapping("/getById")
    fun getPartnerById(@RequestParam partnerId: String): ResVal {
        try {
            partnerDao.getPartnerById(partnerId)
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, partnerDao.getPartnerById(partnerId))
    }

    @GetMapping("/list")
    fun getPartnerList(@RequestParam currentPage: Int, @RequestParam pageSize: Int): ResVal {
        val currentPageNew = (currentPage - 1) * pageSize
        try {
            partnerDao.getPartnerList(currentPageNew, pageSize)
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, partnerDao.getPartnerList(currentPageNew, pageSize))
    }

    @GetMapping("/getCompanyInfo")
    fun getCompanyInfo(@RequestParam partner: String): ResVal {
        var info: CompanyInfo
        try {
            info = partnerService.getCompanyInfo(partner)
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, info)
    }
}