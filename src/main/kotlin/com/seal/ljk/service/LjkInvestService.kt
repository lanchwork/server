package com.seal.ljk.service

import com.seal.ljk.dao.LjkInvestDao
import com.seal.ljk.model.LjkInvest
import com.seal.ljk.query.QLjkInvest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LjkInvestService {

    @Autowired
    lateinit var ljkInvestDao: LjkInvestDao

    fun queryLjkInvestByConditions(qLjkInvest: QLjkInvest): List<LjkInvest> {
        return ljkInvestDao.queryByConditions(qLjkInvest)
    }
}
