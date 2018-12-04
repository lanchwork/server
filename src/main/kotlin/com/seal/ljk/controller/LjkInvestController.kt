package com.seal.ljk.controller

import com.seal.ljk.base.logger
import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LjkInvest
import com.seal.ljk.query.QLjkInvest
import com.seal.ljk.service.LjkInvestService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 投资信息
 * **/
@RestController
@RequestMapping("/ljkInvest")
@Api(description = "投资信息功能相关接口")
class LjkInvestController {

    @Autowired
    lateinit var ljkInvestService: LjkInvestService

    /**
     * 投资信息条件查询
     * **/
    @ApiOperation(value = "投资信息查询")
    @PostMapping("/queryLjkInvest")
    fun queryLjkInvestByConditions(@RequestBody qLjkInvest: QLjkInvest): ResVal {
        val resultList: List<LjkInvest>
        try {
            resultList = ljkInvestService.queryLjkInvestByConditions(qLjkInvest)
        } catch (e: Exception) {
            logger.error("错误信息"+e.toString())
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }


}