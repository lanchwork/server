package com.seal.ljk.dao

import com.seal.ljk.model.LjkOperationalStatistics
import com.seal.ljk.provider.LjkOperationalStatisticsProvider
import com.seal.ljk.query.QLjkOperationalStatistics
import org.apache.ibatis.annotations.SelectProvider
import org.springframework.stereotype.Repository

@Repository
interface LjkOperationalStatisticsDao {

    @SelectProvider(type = LjkOperationalStatisticsProvider::class, method = "queryLjkOperationalStatisticsByConditions")
    fun queryLjkOperationalStatisticsByConditions(qLjkOperationalStatistics: QLjkOperationalStatistics): List<LjkOperationalStatistics>

}
