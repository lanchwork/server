package com.seal.ljk.service

import com.seal.ljk.dao.LjkIncomeStatisticsDao
import com.seal.ljk.model.LjkIncomeStatistics
import com.seal.ljk.query.QLjkIncomeStatistics
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LjkIncomeStatisticsService {

    @Autowired
    lateinit var ljkIncomeStatisticsDao: LjkIncomeStatisticsDao

    fun queryLjkIncomeStatisticsByConditions(qLjkIncomeStatistics: QLjkIncomeStatistics): List<LjkIncomeStatistics> {
        return ljkIncomeStatisticsDao.queryLjkIncomeStatisticsByConditions(qLjkIncomeStatistics)
    }
}
