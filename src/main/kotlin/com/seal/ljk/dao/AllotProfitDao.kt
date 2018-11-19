package com.seal.ljk.dao

import com.seal.ljk.model.AllotProfit
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface AllotProfitDao {

    @Select("select * from allot_profit where partner_id = #{partnerId}")
    fun getByPartnerId(@Param("partnerId") partnerId: String): AllotProfit

    @Insert("insert into allot_profit(allot_profit_id, partner_id, partner_product_cycle, partner_product_day_rate, allot_type, partner_scale, seal_scale, " +
            "platform_wallet_addr, investor_highest_day_rate, create_date, create_user, update_date, update_user, remark) " +
            "values(#{allotProfit.allotProfitId},#{allotProfit.partnerId},#{allotProfit.partnerProductCycle},#{allotProfit.partnerProductDayRate}, " +
            "#{allotProfit.allotType},#{allotProfit.partnerScale},#{allotProfit.sealScale},#{allotProfit.platformWalletAddr}, " +
            "#{allotProfit.investorHighestDayRate},#{allotProfit.createDate},#{allotProfit.createUser},#{allotProfit.updateDate}, " +
            "#{allotProfit.updateUser},#{allotProfit.remark})")
    fun create(@Param("allotProfit") allotProfit : AllotProfit): Int

    @Update("update allot_profit set partner_id=#{allotProfit.partnerId}, partner_product_cycle=#{allotProfit.partnerProductCycle}, partner_product_day_rate=#{allotProfit.partnerProductDayRate}, allot_type=#{allotProfit.allotType}, " +
            "partner_scale=#{allotProfit.partnerScale}, seal_scale=#{allotProfit.sealScale}, platform_wallet_addr=#{allotProfit.platformWalletAddr}, investor_highest_day_rate=#{allotProfit.investorHighestDayRate}, " +
            "create_date=#{allotProfit.createDate}, create_user=#{allotProfit.createUser}, update_date=#{allotProfit.updateDate}, update_user=#{allotProfit.updateUser}, remark=#{allotProfit.remark} " +
            "where allot_profit_id = #{allotProfit.allotProfitId}")
    fun update(@Param("allotProfit") allotProfit: AllotProfit): Int

    @Delete("delete from allot_profit where partner_Id = #{partnerId}")
    fun deleteByPartnerId(@Param("partnerId") partnerId: String): Int

}















