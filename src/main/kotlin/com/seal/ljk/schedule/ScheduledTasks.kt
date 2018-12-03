package com.seal.ljk.schedule

import com.seal.ljk.service.ReconciliationService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

import java.text.SimpleDateFormat
import java.util.Date


@Component
class ScheduledTasks {
    val logger = LoggerFactory.getLogger(javaClass)

    @Autowired
    lateinit var reconciliationService: ReconciliationService

    /**
     * 定时  获取合作方放款数据
     */
    @Scheduled(cron = "0 0/5 * * * *")
    fun pushDataScheduled() {
        logger.info(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date()))
    }

    /**
     * 定时每天凌晨00:30:00 对账统计数据
     */
    @Scheduled(cron = "0 30 0 1/1 * ?")
    fun calculateReconciliation(){
        reconciliationService.calculateReconciliation()
    }
}
