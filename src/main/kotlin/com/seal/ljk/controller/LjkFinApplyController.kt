package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LjkFinApply
import com.seal.ljk.query.QLjkFinApply
import com.seal.ljk.service.LjkFinApplyService
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
class LjkFinApplyController {

    @Autowired
    lateinit var ljkFinApplyService: LjkFinApplyService

    @GetMapping("/queryFinApplyByKey")
    fun queryByKey(@RequestParam channelFinApplyId: String): ResVal{
        val resultList: List<LjkFinApply>
        try {
            resultList = ljkFinApplyService.queryFinApplyByKey(channelFinApplyId)
        } catch (e: Exception){
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }

    @RequestMapping("/queryFinApply")
    fun query(@RequestBody qLjkFinApply: QLjkFinApply): ResVal{
        val resultList: List<Map<String,String>>
        try {
            resultList = ljkFinApplyService.queryFinApply(qLjkFinApply)
        } catch (e: Exception){
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }
}