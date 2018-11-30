package com.seal.ljk.service

import com.seal.ljk.dao.LjkRepayDao
import com.seal.ljk.model.LjkRepay
import com.seal.ljk.query.QLjkRepay
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LjkRepayService {

    @Autowired
    lateinit var ljkRepayDao: LjkRepayDao

    fun queryLjkRepayByConditions(qLjkRepay: QLjkRepay): List<LjkRepay> {
        return ljkRepayDao.queryByConditions(qLjkRepay)
    }
}
