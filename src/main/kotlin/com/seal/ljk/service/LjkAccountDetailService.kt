package com.seal.ljk.service

import com.seal.ljk.dao.LjkAccountDetailDao
import com.seal.ljk.model.LjkAccountDetail
import com.seal.ljk.query.QLjkAccountDetail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LjkAccountDetailService {

    @Autowired
    lateinit var ljkAccountDetailDao: LjkAccountDetailDao

    fun queryLjkAccountDetailByConditions(qLjkAccountDetail: QLjkAccountDetail): List<LjkAccountDetail> {
        return ljkAccountDetailDao.queryByConditions(qLjkAccountDetail)
    }
}
