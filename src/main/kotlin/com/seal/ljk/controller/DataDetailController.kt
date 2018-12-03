package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.DataDetail
import com.seal.ljk.model.DataDetailChannel
import com.seal.ljk.model.DataDetailLocal
import com.seal.ljk.query.*
import com.seal.ljk.service.DataDetailService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/dataDetail")
@Api(description = "数据验证功能相关接口")
class DataDetailController {

    @Autowired
    lateinit var dataDetailService: DataDetailService

    @PostMapping("/queryLinkDetail")
    @ApiOperation(value = "数据验证查询")
    fun queryLinkDetail(@RequestBody qDataDetail: QDataDetail): ResVal {
        val resultList: List<DataDetail>
        try {
            resultList = dataDetailService.queryLinkDetail(qDataDetail)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }

    @PostMapping("/queryDataDetailChannel")
    @ApiOperation(value = "查业务对象明细")
    fun queryDataDetailChannel(@RequestBody qDataDetailChannel: QDataDetailChannel): ResVal {
        val resultList: List<DataDetailChannel>
        try {
            resultList = dataDetailService.queryDataDetailChannel(qDataDetailChannel.channelMarkName, qDataDetailChannel.toChainDate)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }


    @PostMapping("/queryDataDetailBusiness")
    @ApiOperation(value = "查数据明细验证记录")
    fun queryDataDetailBusiness(@RequestBody qDataDetailBusiness: QDataDetailBusiness): ResVal {
        val resultList: List<DataDetailLocal>
        try {
            if(qDataDetailBusiness.businessObject.isEmpty()){
                return ResVal(1, "业务对象不能为空")
            }
            if(qDataDetailBusiness.channelMark.isEmpty()){
                return ResVal(1, "渠道标识")
            }
            resultList = dataDetailService.queryDataDetailBusiness(qDataDetailBusiness)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }


    @PostMapping("/queryDetailVid")
    @ApiOperation(value = "明细验证")
    fun queryDataDetailVid(@RequestBody qDataDetailVid: QDataDetailVid): ResVal {
        try {
            if (qDataDetailVid.businessObject.equals("AccountDetail")) {
                return ResVal(0, dataDetailService.queryLjkAccountDetail(qDataDetailVid.transactionId))
            } else if (qDataDetailVid.businessObject.equals("Attachment")) {
                return ResVal(0, dataDetailService.queryLjkAttachment(qDataDetailVid.transactionId))
            } else if (qDataDetailVid.businessObject.equals("Customer")) {
                return ResVal(0, dataDetailService.queryLjkCustomer(qDataDetailVid.transactionId))
            } else if (qDataDetailVid.businessObject.equals("CustomerDetail")) {
                return ResVal(0, dataDetailService.queryLjkCustomerDetail(qDataDetailVid.transactionId))
            } else if (qDataDetailVid.businessObject.equals("FinApply")) {
                return ResVal(0, dataDetailService.queryLjkFinApply(qDataDetailVid.transactionId))
            } else if (qDataDetailVid.businessObject.equals("IncomeStatistics")) {
                return ResVal(0, dataDetailService.queryLjkIncomeStatistics(qDataDetailVid.transactionId))
            } else if (qDataDetailVid.businessObject.equals("Invest")) {
                return ResVal(0, dataDetailService.queryLjkInvest(qDataDetailVid.transactionId))
            } else if (qDataDetailVid.businessObject.equals("Loan")) {
                return ResVal(0, dataDetailService.queryLjkLoan(qDataDetailVid.transactionId))
            } else if (qDataDetailVid.businessObject.equals("OperationalStatistics")) {
                return ResVal(0, dataDetailService.queryLjkOperationalStatistics(qDataDetailVid.transactionId))
            } else if (qDataDetailVid.businessObject.equals("Overdue")) {
                return ResVal(0, dataDetailService.queryLjkOverdue(qDataDetailVid.transactionId))
            } else if (qDataDetailVid.businessObject.equals("Repay")) {
                return ResVal(0, dataDetailService.queryLjkRepay(qDataDetailVid.transactionId))
            } else if (qDataDetailVid.businessObject.equals("Risk")) {
                return ResVal(0, dataDetailService.queryLjkRisk(qDataDetailVid.transactionId))
            } else if (qDataDetailVid.businessObject.equals("RiskDetail")) {
                return ResVal(0, dataDetailService.queryLjkRiskDetail(qDataDetailVid.transactionId))
            } else if (qDataDetailVid.businessObject.equals("StatusChange")) {
                return ResVal(0, dataDetailService.queryLjkStatusChange(qDataDetailVid.transactionId))
            } else{
                return ResVal(1, "没有该 ${qDataDetailVid.businessObject} ")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
    }

    @PostMapping("/queryToChainVid")
    @ApiOperation(value = "数据验证")
    fun queryToChainVid(@RequestBody secondHash: String): ResVal {
        return ResVal(0, dataDetailService.queryToChainVid(secondHash))
    }
}