package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.ExchangeRateAllocation
import com.seal.ljk.service.ExchangeRateAllocationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/exchangeRate")
class ExchangeRateAllocationController {

    @Autowired
    lateinit var exchangeRateAllocationService: ExchangeRateAllocationService

    /**
     * 获取所有的汇率
     */
    @GetMapping("/all")
    fun getAllExchangeRate(): ResVal {
        val resultList: List<ExchangeRateAllocation>
        try {
            resultList=exchangeRateAllocationService.getAllExchangeRate()
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }

    /**
     * 创建汇率
     */
    @PostMapping("/add")
    fun create(@RequestBody exchangeRateAllocation:ExchangeRateAllocation):ResVal{

        try {
            exchangeRateAllocationService.createExchangeRate(exchangeRateAllocation)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "ok")
    }

    @PostMapping("/update")
    fun update(@RequestBody exchangeRateAllocation:ExchangeRateAllocation):ResVal{

        try {
            exchangeRateAllocationService.updateExchangeRateById(exchangeRateAllocation)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "ok")
    }

    /**
     * 查询所有同币种的所有记录
     */
    @GetMapping("/find")
    fun findByCurrency(@RequestParam currency:String):ResVal{
        val resultList: List<ExchangeRateAllocation>
        try {
            resultList = exchangeRateAllocationService.getExchangeRateByCurrency(currency)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }

}