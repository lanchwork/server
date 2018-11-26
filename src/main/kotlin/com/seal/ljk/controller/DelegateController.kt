package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.Delegate
import com.seal.ljk.model.Partner
import com.seal.ljk.service.DelegateService
import org.apache.ibatis.annotations.Param
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(("/delegate"))
class DelegateController {

    @Autowired
    lateinit var delegateService: DelegateService

    @GetMapping("/all")
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
    fun create(@RequestBody delegate : Delegate) : ResVal{
           try {
               delegateService.createDelegate(delegate)
           }catch (e : Exception){
               e.printStackTrace()
               return ResVal(1,"Data Access Error!")
           }
        return ResVal(0,"success")
    }

    @GetMapping("/delete")
    fun deleterById(@Param("delegateId") delegateId: String) : ResVal {
        try {
            delegateService.deleteDelegateById(delegateId)
        }catch (e : Exception){
            e.printStackTrace()
            return ResVal(1,"Data Access Error!")
        }
        return ResVal(0,"success")
    }

    @RequestMapping("/update")
    fun updateById(@RequestBody delegate: Delegate) : ResVal {

        try {
            delegateService.updateDelegateById(delegate)
        }catch (e : Exception){
            e.printStackTrace()
            return ResVal(1,"Data Access Error!")
        }
        return ResVal(0,"success")
    }

    @GetMapping("/getById")
    fun getById(@RequestParam("delegateId") delegateId : String) : ResVal {
        val delegate : Delegate
        try {
            delegate = delegateService.getDelegateById(delegateId)
        }catch (e : Exception){
            return ResVal(1,"Data Access Error!")
        }
        return ResVal(0,delegate)
    }

    @GetMapping("/list")
    fun getList(@RequestParam("currentPage") currentPage : Int, @RequestParam("pageSize") pageSize : Int) : ResVal {
        val delegates : List<Delegate>
        try {
            val currentPageNew = (currentPage - 1) * pageSize
            delegates = delegateService.getDelegateList(currentPageNew, pageSize)
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