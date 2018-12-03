package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LjkCustomerDetail
import com.seal.ljk.service.LjkCustomerDetailService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


/**
 * @program: si-server
 *
 * @description: 链金控客户详细信息
 *
 * @author: tingyx
 *
 * @create: 2018-11-30 11:30
 **/
@RestController
@RequestMapping("/ljkCustomerDetail")
@Api(description = "客户详细信息功能相关接口")
class LjkCustomerDetailController {

    @Autowired
    lateinit var ljkCustomerDetailService: LjkCustomerDetailService

    @PostMapping("/getCustomerDetailByKey")
    @ApiOperation(value = "查询客户详细信息")
    fun getCustomerDetailByKey(@RequestParam customerId: String): ResVal{
        val resultList: List<LjkCustomerDetail>
        try {
            resultList = ljkCustomerDetailService.getCustomerDetailByKey(customerId)
        } catch (e: Exception){
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }
}