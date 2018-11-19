package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.PartnerProduct
import com.seal.ljk.service.PartnerProductService
import org.apache.ibatis.annotations.Param
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(("/partnerProduct"))
class PartnerProductController {

    @Autowired
    lateinit var partnerProductService: PartnerProductService

    @GetMapping("/all")
    fun getAll() : Any {
        val partnerProducts :List<PartnerProduct>
        try {
            partnerProducts = partnerProductService.getAllPartnerProduct()
        }catch (e : Exception){
            return ResVal(1,"Data Access Error!")
        }
        return ResVal(0,partnerProducts)
    }

    @PostMapping("/add")
    fun create(@RequestBody partnerProduct : PartnerProduct) : ResVal{
           try {
               partnerProductService.createPartnerProduct(partnerProduct)
           }catch (e : Exception){
               return ResVal(1,"Data Access Error!")
           }
        return ResVal(0,"success")
    }

    @GetMapping("/delete")
    fun deleterById(@Param("partnerProductId") partnerProductId : String) : ResVal {
        try {
            partnerProductService.deletePartnerProductById(partnerProductId)
        }catch (e : Exception){
            return ResVal(1,"Data Access Error!")
        }
        return ResVal(0,"success")
    }

    @RequestMapping("/update")
    fun updateById(@RequestBody partnerProduct: PartnerProduct) : ResVal {

        try {
            partnerProductService.updatePartnerProductById(partnerProduct)
        }catch (e : Exception){
            return ResVal(1,"Data Access Error!")
        }
        return ResVal(0,"success")
    }

    @GetMapping("/getById")
    fun getById(@RequestParam("partnerProductId") partnerProductId : String) : ResVal {
        val partnerProduct : PartnerProduct
        try {
            partnerProduct = partnerProductService.getPartnerProductById(partnerProductId)
        }catch (e : Exception){
            return ResVal(1,"Data Access Error!")
        }
        return ResVal(0,partnerProduct)
    }

    @GetMapping("/list")
    fun getList(@RequestParam("currentPage") currentPage : Int, @RequestParam("pageSize") pageSize : Int) : ResVal {
        val partnerProducts : List<PartnerProduct>
        try {
            val currentPageNew = (currentPage - 1) * pageSize
            partnerProducts = partnerProductService.getPartnerProductList(currentPageNew, pageSize)
        }catch (e : Exception){
            return ResVal(1,"Data Access Error!")
        }
        return ResVal(0,partnerProducts)
    }

}