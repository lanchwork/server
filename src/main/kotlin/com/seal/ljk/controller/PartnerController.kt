package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.Partner
import com.seal.ljk.query.QPartner
import com.seal.ljk.service.PartnerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/partner")
class PartnerController {

    @Autowired
    lateinit var partnerService: PartnerService

    @PostMapping("/byCondition")
    fun getPartnerByCondition(@RequestBody qPartner: QPartner): ResVal {
        val resultList: List<Partner>
        try {
            resultList = partnerService.getPartnerByCondition(qPartner)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }

    @GetMapping("/all")
    fun getAllPartner(): ResVal {
        val resultList: List<Partner>
        try {
            resultList = partnerService.getAllPartner()
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
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
        val result: Partner
        try {
            result = partnerService.getPartnerById(partnerId)
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, result)
    }

    @GetMapping("/list")
    fun getPartnerList(@RequestParam currentPage: Int, @RequestParam pageSize: Int): ResVal {
        val resultList: List<Partner>
        val currentPageNew = (currentPage - 1) * pageSize
        try {
            resultList = partnerService.getPartnerList(currentPageNew, pageSize)
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }

    /**
     * 选择合作方
     */
    @RequestMapping("/openPartner")
    fun getOpenPartner():ResVal{
        val resultList: List<Partner>
        try {
            resultList = partnerService.getOpenPartner()
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }
}