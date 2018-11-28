package com.seal.ljk.schedule

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

import java.text.SimpleDateFormat
import java.util.Date


@Component
class ScheduledTasks {
    val logger = LoggerFactory.getLogger(javaClass)

    /**
     * 定时  获取合作方放款数据
     */
    @Scheduled(cron = "0 0/5 * * * *")
    fun pushDataScheduled() {
        logger.info(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date()))
    }
}
