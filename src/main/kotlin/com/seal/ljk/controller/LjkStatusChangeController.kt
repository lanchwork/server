package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LjkStatusChange
import com.seal.ljk.query.QLjkStatusChange
import com.seal.ljk.service.LjkStatusChangeService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 状态迁变
 * **/
@RestController
@RequestMapping("/ljkStatusChange")
@Api(description = "状态迁变功能相关接口")
class LjkStatusChangeController {

    @Autowired
    lateinit var ljkStatusChangeService: LjkStatusChangeService

    /**
     * 状态迁变条件查询
     * **/
    @ApiOperation(value = "状态迁变查询")
    @PostMapping("/queryLjkStatusChange")
    fun queryLjkStatusChangeByConditions(@RequestBody qLjkStatusChange: QLjkStatusChange): ResVal {
        val resultList: List<LjkStatusChange>
        try {
            resultList = ljkStatusChangeService.queryLjkStatusChangeByConditions(qLjkStatusChange)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }


}