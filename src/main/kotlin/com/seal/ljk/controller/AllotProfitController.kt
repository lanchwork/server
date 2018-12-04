package com.seal.ljk.controller

import com.seal.ljk.base.logger
import com.seal.ljk.common.ResVal
import com.seal.ljk.model.AllotProfit
import com.seal.ljk.service.AllotProfitService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Exception


/**
 * @program: si-server
 *
 * @description:
 *
 * @author: tingyx
 *
 * @create: 2018-11-16 11:55
 **/
@RestController
@RequestMapping("/allotProfit")
@Api(description = "分润配置功能相关接口")
class AllotProfitController {

    @Autowired
    lateinit var allotProfitService: AllotProfitService

    @PostMapping("/getByPartnerId")
    @ApiOperation(value = "查询合作方ID为参数partnerId的分润配置")
    fun getByPartnerId(@RequestParam partnerId: String): ResVal{
        val allotProfit: List<AllotProfit>
        try {
            allotProfit = allotProfitService.getByPartnerId(partnerId)
        } catch (e: Exception){
            logger.error("错误信息"+e.toString())
            return ResVal(1, "Data Access Error")
        }
        return ResVal(0, allotProfit)
    }

    @PostMapping("/add")
    @ApiOperation(value = "创建一条分润配置记录")
    fun create(@RequestBody allotProfit: AllotProfit): ResVal{
        try {
            allotProfitService.create(allotProfit)
        } catch (e: Exception){
            logger.error("错误信息"+e.toString())
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新一条分润配置")
    fun update(@RequestBody allotProfit: AllotProfit): ResVal{
        try {
            allotProfitService.update(allotProfit)
        } catch (e: Exception){
            logger.error("错误信息"+e.toString())
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除一条分润配置")
    fun deleteByPartnerId(@RequestParam partnerId: String): ResVal{
        try {
            allotProfitService.deleteByPartnerId(partnerId)
        } catch (e: Exception){
            logger.error("错误信息"+e.toString())
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    @PostMapping("/list")
    @ApiOperation(value = "查询第currentPage页的pageSize条分润配置记录")
    fun getList(@RequestParam("currentPage") currentPage : Int, @RequestParam("pageSize") pageSize : Int) : ResVal {
        val allotProfit : List<AllotProfit>
        try {
            allotProfit = allotProfitService.getAllotProfitList(currentPage, pageSize)
        }catch (e : Exception){
            logger.error("错误信息"+e.toString())
            return ResVal(1,"Data Access Error!")
        }
        return ResVal(0,allotProfit)
    }

}