package com.seal.ljk.dao

import com.seal.ljk.model.PartnerProduct
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface PartnerProductDao {

    @Select("select * from partner_product")
    fun getAllPartnerProduct(): List<PartnerProduct>

    @Select("select * from partner_product where partner_product_id = #{partnerProductId}")
    fun getPartnerProductById(@Param("partnerProductId") partnerProductId : String): PartnerProduct

    @Insert("insert into partner_product(" +
            "partner_product_id, allot_profit_id, product_name, day_rate, open_flag, end_date, remark, create_date, create_user, update_date, update_user" +
            ") values(" +
            "#{partnerProduct.partnerProductId}, #{partnerProduct.allotProfitId}, #{partnerProduct.productName}, #{partnerProduct.dayRate}, #{partnerProduct.openFlag}, #{partnerProduct.endDate}, #{partnerProduct.remark}, #{partnerProduct.createDate}, #{partnerProduct.createUser}, #{partnerProduct.updateDate}, #{partnerProduct.updateUser})")
    @Options(useGeneratedKeys = true, keyProperty = "partnerProductId")
    fun createPartnerProduct(@Param("partnerProduct") partnerProduct : PartnerProduct):Int

    @Delete("delete from partner_product where partner_Product_Id = #{partnerProductId}")
    fun deletePartnerProductById(@Param("partnerProductId") partnerProductId: String):Int

    @Update("update partner_product set  allot_Profit_Id=#{partnerProduct.allotProfitId}, product_Name=#{partnerProduct.productName}, day_Rate=#{partnerProduct.dayRate}, open_Flag=#{partnerProduct.openFlag}, end_Date=#{partnerProduct.endDate}, remark=#{partnerProduct.remark}, create_Date=#{partnerProduct.createDate}, create_User=#{partnerProduct.createUser}, update_Date=#{partnerProduct.updateDate}, update_User=#{partnerProduct.updateUser} where partner_Product_Id=#{partnerProduct.partnerProductId}")
    fun updatePartnerProductById(@Param("partnerProduct") partnerProduct :PartnerProduct ): Int

    @Select("select partner_product_id, allot_profit_id, product_name, day_rate, open_flag, end_date, remark, create_date, create_user, update_date, update_user from partner_product limit #{currentPage}, #{pageSize}")
    fun getPartnerProductList(@Param("currentPage") currentPage : Int, @Param("pageSize") pageSize : Int): List<PartnerProduct>

}
