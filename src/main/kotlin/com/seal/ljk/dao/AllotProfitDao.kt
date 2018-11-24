package com.seal.ljk.dao

import com.seal.ljk.model.AllotProfit
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface AllotProfitDao {

    @Select("select * from allot_profit where partner_id = #{partnerId}")
    fun getByPartnerId(@Param("partnerId") partnerId: String): List<AllotProfit>

    @Insert("insert into allot_profit(allot_profit_id, partner_id, seal_wallet_addr, income_method, partner_ratio, seal_ratio, " +
            "create_date, create_user, update_date, update_user, remark) " +
            "values(#{allotProfit.allotProfitId},#{allotProfit.partnerId},#{allotProfit.sealWalletAddr},#{allotProfit.incomeMethod}, " +
            "#{allotProfit.partnerRatio},#{allotProfit.sealRatio}, " +
            "#{allotProfit.createDate},#{allotProfit.createUser},#{allotProfit.updateDate}, #{allotProfit.updateUser},#{allotProfit.remark})")
    fun create(@Param("allotProfit") allotProfit : AllotProfit): Int

    @Update("update allot_profit set partner_id=#{allotProfit.partnerId}, seal_wallet_addr=#{allotProfit.sealWalletAddr}, income_method=#{allotProfit.incomeMethod}, " +
            "partner_ratio=#{allotProfit.partnerRatio}, seal_ratio=#{allotProfit.sealRatio}, investor_highest_day_rate=#{allotProfit.investorHighestDayRate}, " +
            "create_date=#{allotProfit.createDate}, create_user=#{allotProfit.createUser}, update_date=#{allotProfit.updateDate}, update_user=#{allotProfit.updateUser}, remark=#{allotProfit.remark} " +
            "where allot_profit_id = #{allotProfit.allotProfitId}")
    fun update(@Param("allotProfit") allotProfit: AllotProfit): Int

    @Delete("delete from allot_profit where partner_Id = #{partnerId}")
    fun deleteByPartnerId(@Param("partnerId") partnerId: String): Int

}















