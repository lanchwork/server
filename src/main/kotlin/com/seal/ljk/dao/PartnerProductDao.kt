package com.seal.ljk.dao

import com.seal.ljk.model.PartnerProduct
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface PartnerProductDao {

    @Select("select * from partner_product")
    fun getAllPartnerProduct(): List<PartnerProduct>

    @Select("select * from partner_product where partnerProduct_Id = #{partnerProductId}")
    fun getPartnerProductById(@Param("partnerProductId") partnerProductId : String): PartnerProduct

    @Insert("insert into partner_product(" +
            "partnerProduct_Id, allot_ProfitId, product_Name, day_Rate, is_Open, end_Date, remark, create_Date, create_User, update_Date, update_User" +
            ") values(" +
            "#{partnerProduct.partnerProductId}, #{partnerProduct.allotProfitId}, #{partnerProduct.productName}, #{partnerProduct.dayRate}, #{partnerProduct.isOpen}, #{partnerProduct.endDate}, #{partnerProduct.remark}, #{partnerProduct.createDate}, #{partnerProduct.createUser}, #{partnerProduct.updateDate}, #{partnerProduct.updateUser})")
    @Options(useGeneratedKeys = true, keyProperty = "partnerProductId")
    fun createPartnerProduct(@Param("partnerProduct") partnerProduct : PartnerProduct):Int

    @Delete("delete from partner_product where partnerProductId = #{partnerProductId}")
    fun deletePartnerProductById(@Param("partnerProductId") partnerProductId: String):Int

    @Update("update partner_product set  allotProfit_Id=#{partnerProduct.allotProfitId}, product_Name=#{partnerProduct.productName}, day_Rate=#{partnerProduct.dayRate}, is_Open=#{partnerProduct.isOpen}, end_Date=#{partnerProduct.endDate}, remark=#{partnerProduct.remark}, create_Date=#{partnerProduct.createDate}, create_User=#{partnerProduct.createUser}, update_Date=#{partnerProduct.updateDate}, update_User=#{partnerProduct.updateUser} where partnerProductId=#{partnerProduct.partnerProductId}")
    fun updatePartnerProductById(@Param("partnerProduct") partnerProduct :PartnerProduct ): Int

    @Select("select * from partner_product limit #{currentPage}, #{pageSize}")
    fun getPartnerProductList(@Param("currentPage") currentPage : Int, @Param("pageSize") pageSize : Int): List<PartnerProduct>

}
