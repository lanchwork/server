package com.seal.ljk.controller

import com.seal.ljk.base.logger
import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LjkFinApply
import com.seal.ljk.query.QLjkFinApply
import com.seal.ljk.service.LjkFinApplyService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


/**
 * @program: si-server
 *
 * @description: 链金控融资信息
 *
 * @author: tingyx
 *
 * @create: 2018-11-30 14:22
 **/
@RestController
@RequestMapping("/ljkFinApply")
@Api(description = "融资信息功能相关接口")
class LjkFinApplyController {

    @Autowired
    lateinit var ljkFinApplyService: LjkFinApplyService

    @PostMapping("/queryFinApplyByKey")
    @ApiOperation(value = "查询融资申请编号为channelFinApplyId的融资信息")
    fun queryByKey(@RequestParam channelFinApplyId: String): ResVal{
        val resultList: List<LjkFinApply>
        try {
            resultList = ljkFinApplyService.queryFinApplyByKey(channelFinApplyId)
        } catch (e: Exception){
            logger.error("错误信息"+e.toString())
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }

    @PostMapping("/queryFinApply")
    @ApiOperation(value = "查询融资统计信息")
    fun query(@RequestBody qLjkFinApply: QLjkFinApply): ResVal{
        val resultList: List<Map<String,String>>
        try {
            resultList = ljkFinApplyService.queryFinApply(qLjkFinApply)
        } catch (e: Exception){
            logger.error("错误信息"+e.toString())
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }
}