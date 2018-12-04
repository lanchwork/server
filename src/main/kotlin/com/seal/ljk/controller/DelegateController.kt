package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.Delegate
import com.seal.ljk.model.Partner
import com.seal.ljk.service.DelegateService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.apache.ibatis.annotations.Param
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(("/delegate"))
@Api(description = "委托设置功能相关接口")
class DelegateController {

    @Autowired
    lateinit var delegateService: DelegateService

    @PostMapping("/all")
    @ApiOperation(value = "查询所有委托设置")
    fun getAll() : Any {
        val delegates :List<Delegate>
        try {
            delegates = delegateService.getAllDelegate()
        }catch (e : Exception){
            return ResVal(1,"Data Access Error!")
        }
        return ResVal(0,delegates)
    }

    @PostMapping("/add")
    @ApiOperation(value = "创建一条委托设置记录")
    fun create(@RequestBody delegate : Delegate) : ResVal{
           try {
               delegateService.createDelegate(delegate)
           }catch (e : Exception){
               e.printStackTrace()
               return ResVal(1,"Data Access Error!")
           }
        return ResVal(0,"success")
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除一条委托设置")
    fun deleterById(@Param("delegateId") delegateId: String) : ResVal {
        try {
            delegateService.deleteDelegateById(delegateId)
        }catch (e : Exception){
            e.printStackTrace()
            return ResVal(1,"Data Access Error!")
        }
        return ResVal(0,"success")
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新一条委托设置")
    fun updateById(@RequestBody delegate: Delegate) : ResVal {

        try {
            delegateService.updateDelegateById(delegate)
        }catch (e : Exception){
            e.printStackTrace()
            return ResVal(1,"Data Access Error!")
        }
        return ResVal(0,"success")
    }

    @PostMapping("/getById")
    @ApiOperation(value = "查询委托设置ID为参数delegateId的委托设置")
    fun getById(@RequestParam("delegateId") delegateId : String) : ResVal {
        val delegate : Delegate
        try {
            delegate = delegateService.getDelegateById(delegateId)
        }catch (e : Exception){
            return ResVal(1,"Data Access Error!")
        }
        return ResVal(0,delegate)
    }

    @PostMapping("/list")
    @ApiOperation(value = "查询第currentPage页的pageSize条委托设置记录")
    fun getList(@RequestParam("currentPage") currentPage : Int, @RequestParam("pageSize") pageSize : Int) : ResVal {
        val delegates : List<Delegate>
        try {
            delegates = delegateService.getDelegateList(currentPage, pageSize)
        }catch (e : Exception){
            return ResVal(1,"Data Access Error!")
        }
        return ResVal(0,delegates)
    }

    /**
     * 获取可委托列表
     * lanch
     */
    @PostMapping("/delegateData")
    @ApiOperation(value = "获取可委托列表")
    fun getDelegateData(@RequestBody partner:Partner) : ResVal {
        val delegates : List<Map<String, Any>>
        try {

            delegates = delegateService.getDelegateData(partner)
        }catch (e : Exception){
            e.printStackTrace()
            return ResVal(1,"Data Access Error!")
        }
        return ResVal(0,delegates)
    }

}