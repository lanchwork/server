package com.seal.ljk.service

import com.seal.ljk.dao.LjkStatusChangeDao
import com.seal.ljk.model.LjkStatusChange
import com.seal.ljk.query.QLjkStatusChange
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LjkStatusChangeService {

    @Autowired
    lateinit var ljkStatusChangeDao: LjkStatusChangeDao

    fun queryLjkStatusChangeByConditions(qLjkStatusChange: QLjkStatusChange): List<LjkStatusChange> {
        return ljkStatusChangeDao.queryByConditions(qLjkStatusChange)
    }
}
