package com.seal.ljk.service

import com.seal.ljk.dao.LjkOverdueDao
import com.seal.ljk.model.LjkOverdue
import com.seal.ljk.query.QLjkOverdue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LjkOverdueService {

    @Autowired
    lateinit var ljkOverdueDao: LjkOverdueDao

    fun queryLjkOverdueByConditions(qLjkOverdue: QLjkOverdue): List<LjkOverdue> {
        return ljkOverdueDao.queryLjkOverdueByConditions(qLjkOverdue)
    }

}
