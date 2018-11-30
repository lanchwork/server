package com.seal.ljk.dao

import com.seal.ljk.model.LjkIncomeStatistics
import com.seal.ljk.provider.LjkIncomeStatisticsProvider
import com.seal.ljk.query.QLjkIncomeStatistics
import org.apache.ibatis.annotations.SelectProvider
import org.springframework.stereotype.Repository

@Repository
interface LjkIncomeStatisticsDao {

    @SelectProvider(type = LjkIncomeStatisticsProvider::class, method = "queryLjkIncomeStatisticsByConditions")
    fun queryLjkIncomeStatisticsByConditions(qLjkIncomeStatistics: QLjkIncomeStatistics): List<LjkIncomeStatistics>

}
