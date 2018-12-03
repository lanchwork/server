package com.seal.ljk.dao

import com.seal.ljk.model.ExchangeRateAllocation
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository

@Repository
interface ExchangeRateAllocationDao {
    @Select("SELECT MAX(id) FROM lc_exchange_rate")
    fun getMaxId():String

    @Select("SELECT `id`, `currency`, `name`, `exchange_rate`, `show`, `update_time`, `remark` FROM lc_exchange_rate WHERE update_time in (SELECT MAX(update_time) FROM lc_exchange_rate GROUP BY currency) ")
    fun getAllNewExchangeRate(): List<ExchangeRateAllocation>

    @Select("select * FROM lc_exchange_rate  where currency=#{currency} ORDER BY update_time DESC")
    fun getExchangeRateByCurrency(currency: String): List<ExchangeRateAllocation>

    @Select("select * FROM lc_exchange_rate  where id=#{id}")
    fun getExchangeRateById(id: String): ExchangeRateAllocation

//    @Update("update lc_exchange_rate set exchange_rate=#{exchangeRateAllocation.exchangeRate} where exchange_rate_id=#{exchangeRateAllocation.exchangeRateId}")
//    fun updateExchangeRateById(@Param("exchangeRateAllocation") exchangeRateAllocation:ExchangeRateAllocation)

    @Insert("INSERT INTO `seal-ljk`.`lc_exchange_rate`(`id`, `currency`, `name`, `exchange_rate`, `show`, `update_time`, `remark`) VALUES " +
            "(#{exchangeRateAllocation.id},#{exchangeRateAllocation.currency},#{exchangeRateAllocation.name},#{exchangeRateAllocation.exchangeRate},#{exchangeRateAllocation.show},#{exchangeRateAllocation.updateTime},#{exchangeRateAllocation.remark})"
             )
    fun createExchangeRate(@Param("exchangeRateAllocation") exchangeRateAllocation:ExchangeRateAllocation):Int
}