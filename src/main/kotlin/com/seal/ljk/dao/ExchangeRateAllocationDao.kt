package com.seal.ljk.dao

import com.seal.ljk.model.ExchangeRateAllocation
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository

@Repository
interface ExchangeRateAllocationDao {
    @Select("SELECT MAX(id) FROM\texchange_rate_allocation")
    fun getMaxId():String

    @Select("SELECT `id`, `currency`, `name`, `exchange_rate`, `show`, `update_time`, `remark` FROM exchange_rate_allocation WHERE update_time in (SELECT MAX(update_time) FROM exchange_rate_allocation GROUP BY currency) ")
    fun getAllNewExchangeRate(): List<ExchangeRateAllocation>

    @Select("select * FROM exchange_rate_allocation  where currency=#{currency} ORDER BY update_time DESC")
    fun getExchangeRateByCurrency(currency: String): List<ExchangeRateAllocation>

    @Select("select * FROM exchange_rate_allocation  where id=#{id}")
    fun getExchangeRateById(id: String): ExchangeRateAllocation

//    @Update("update exchange_rate_allocation set exchange_rate=#{exchangeRateAllocation.exchangeRate} where exchange_rate_id=#{exchangeRateAllocation.exchangeRateId}")
//    fun updateExchangeRateById(@Param("exchangeRateAllocation") exchangeRateAllocation:ExchangeRateAllocation)

    @Insert("INSERT INTO `seal-ljk`.`exchange_rate_allocation`(`id`, `currency`, `name`, `exchange_rate`, `show`, `update_time`, `remark`) VALUES " +
            "(#{exchangeRateAllocation.id},#{exchangeRateAllocation.currency},#{exchangeRateAllocation.name},#{exchangeRateAllocation.exchangeRate},#{exchangeRateAllocation.show},#{exchangeRateAllocation.updateTime},#{exchangeRateAllocation.remark})"
             )
    fun createExchangeRate(@Param("exchangeRateAllocation") exchangeRateAllocation:ExchangeRateAllocation):Int
}