package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.CompanyInfo
import com.seal.ljk.model.Partner
import com.seal.ljk.service.PartnerService
import com.seal.ljk.query.QPartner
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/partner")
@Api("合作方相关功能接口")
class PartnerController {

    @Autowired
    lateinit var partnerService: PartnerService

    @PostMapping("/byCondition")
    @ApiOperation("根据界面条件获取合作方")
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
    @ApiOperation("获取所有合作方")
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
    @ApiOperation("创建合作方")
    fun createPartner(@RequestBody partner: Partner): ResVal {
        try {
            partnerService.createPartner(partner)
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    @GetMapping("/delete")
    @ApiOperation("根据ID删除合作方")
    fun deletePartnerById(@RequestParam partnerId: String): ResVal {
        try {
            val result = partnerService.deletePartnerById(partnerId)
            //若合作方名下的产品已经产生交易，则无法删除
            if(result == -1){
                return ResVal(-1, "Partner's products already have transactions")
            }
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    @RequestMapping("/update")
    @ApiOperation("根据ID更新合作方")
    fun updatePartnerById(@RequestBody partner: Partner): ResVal {
        try {
            partnerService.updatePartnerById(partner)
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    @GetMapping("/getById")
    @ApiOperation("根据ID获取合作方")
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
    @ApiOperation("获取合作方的列表")
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

    @GetMapping("/getCompanyInfo")
    @ApiOperation("获取合作方公司信息")
    fun getCompanyInfo(@RequestParam partner: String): ResVal {
        var info: CompanyInfo
        try {
            info = partnerService.getCompanyInfo(partner)
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, info)
    }
    /**
     * 选择合作方
     */
    @RequestMapping("/openPartner")
    @ApiOperation("获取open状态的合作方")
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