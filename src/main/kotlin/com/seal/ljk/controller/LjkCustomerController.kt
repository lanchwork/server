package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.LjkCustomer
import com.seal.ljk.query.QLjkCustomer
import com.seal.ljk.service.LjkCustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


/**
 * @program: si-server
 *
 * @description: 炼金控客户基本信息查询
 *
 * @author: tingyx
 *
 * @create: 2018-11-30 10:03
 **/
@RestController
@RequestMapping("/ljkCustomer")
class LjkCustomerController {

    @Autowired
    lateinit var ljkCustomerService: LjkCustomerService

    @RequestMapping("/queryCustomer")
    fun query(@RequestBody qLjkCustomer: QLjkCustomer): ResVal{
        val resultList: List<LjkCustomer>
        try {
            resultList = ljkCustomerService.query(qLjkCustomer)
        } catch (e: Exception){
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }

}