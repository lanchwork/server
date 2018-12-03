package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.InvestDetail
import com.seal.ljk.query.QInvestDetail
import com.seal.ljk.service.InvestDetailService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/investDetail")
@Api(description = "投资明细相关功能接口")
class InvestDetailController {

    @Autowired
    lateinit var investDetailService: InvestDetailService

    /***
     * 授权投资明细查询
     */
    @PostMapping("/authorizeInvestDetail")
    @ApiOperation(value = "授权投资明细查询")
    fun queryAuthorizeInvestDetail(@RequestBody qInvestDetail: QInvestDetail): ResVal {
        val resultList: List<InvestDetail>
        try {
            resultList = investDetailService.queryAuthorizeInvestDetail(qInvestDetail)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }

    /***
     * 投资列表
     */
    @PostMapping("/byUser")
    @ApiOperation(value = "根据用户获取投资列表")
    fun getInvestDetailByUser(@RequestParam userNo: String): ResVal {
        val resultList: List<InvestDetail>
        try {
            resultList = investDetailService.getInvestDetailByUser(userNo)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }

    /*已投资未回款列表*/
    @PostMapping("/nonReturnList")
    @ApiOperation(value = "已投资未回款列表")
    fun getNonReturnList(@RequestParam investorWalletAddr: String,@RequestParam currentPage: Int, @RequestParam pageSize: Int): ResVal {
        val resultList: List<InvestDetail>
        val currentPageNew = (currentPage - 1) * pageSize
        try {
            resultList=investDetailService.getNonReturnList(investorWalletAddr,currentPageNew, pageSize)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }
}