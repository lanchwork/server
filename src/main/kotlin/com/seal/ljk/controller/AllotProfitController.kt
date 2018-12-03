package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.AllotProfit
import com.seal.ljk.service.AllotProfitService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
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
class AllotProfitController {

    @Autowired
    lateinit var allotProfitService: AllotProfitService

    @RequestMapping("/getByPartnerId")
    fun getByPartnerId(@RequestParam partnerId: String): ResVal{
        val allotProfit: List<AllotProfit>
        try {
            allotProfit = allotProfitService.getByPartnerId(partnerId)
        } catch (e: Exception){
            return ResVal(1, "Data Access Error")
        }
        return ResVal(0, allotProfit)
    }

    @RequestMapping("/add")
    fun create(@RequestBody allotProfit: AllotProfit): ResVal{
        try {
            allotProfitService.create(allotProfit)
        } catch (e: Exception){
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    @RequestMapping("/update")
    fun update(@RequestBody allotProfit: AllotProfit): ResVal{
        try {
            allotProfitService.update(allotProfit)
        } catch (e: Exception){
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    @RequestMapping("/delete")
    fun deleteByPartnerId(@RequestParam partnerId: String): ResVal{
        try {
            allotProfitService.deleteByPartnerId(partnerId)
        } catch (e: Exception){
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

}