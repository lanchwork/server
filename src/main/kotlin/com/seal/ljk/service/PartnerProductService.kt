package com.seal.ljk.service

import com.seal.ljk.dao.PartnerProductDao
import com.seal.ljk.model.PartnerProduct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PartnerProductService {
    @Autowired
    lateinit var partnerProductDao: PartnerProductDao

    fun getAllPartnerProduct() : List<PartnerProduct> {

        return partnerProductDao.getAllPartnerProduct()
    }

    fun createPartnerProduct( partnerProduct:PartnerProduct) : Int {

        partnerProduct.createUser = "System"            //创建人
        partnerProduct.createDate = Date()              //创建时间
        return partnerProductDao.createPartnerProduct( partnerProduct)
    }

    fun deletePartnerProductById(partnerProductId : String) : Int {
        return partnerProductDao.deletePartnerProductById(partnerProductId)
    }

    fun updatePartnerProductById(partnerProduct : PartnerProduct) : Int {
        partnerProduct.updateUser = ""            //修改人
        partnerProduct.updateDate = Date()         //修改时间
        return partnerProductDao.updatePartnerProductById(partnerProduct)
    }

    fun getPartnerProductById(partnerProductId : String) : PartnerProduct {
        return partnerProductDao.getPartnerProductById(partnerProductId)
    }

    fun getPartnerProductList(currentPage : Int, pageSize : Int) : List<PartnerProduct> {
        val currentPageNew = (currentPage - 1) * pageSize
        return partnerProductDao.getPartnerProductList(currentPageNew, pageSize)
    }
}