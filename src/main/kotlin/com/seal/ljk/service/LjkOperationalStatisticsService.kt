package com.seal.ljk.service


import com.seal.ljk.dao.LjkOperationalStatisticsDao
import com.seal.ljk.model.LjkOperationalStatistics
import com.seal.ljk.query.QLjkOperationalStatistics
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LjkOperationalStatisticsService {

    @Autowired
    lateinit var ljkOperationalStatisticsDao: LjkOperationalStatisticsDao

    fun queryLjkOperationalStatisticsByConditions(qLjkOperationalStatistics: QLjkOperationalStatistics): List<LjkOperationalStatistics> {
        return ljkOperationalStatisticsDao.queryLjkOperationalStatisticsByConditions(qLjkOperationalStatistics)
    }
}
