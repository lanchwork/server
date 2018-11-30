package com.seal.ljk.service

import com.seal.ljk.dao.LjkCollectionDao
import com.seal.ljk.model.LjkCollection
import com.seal.ljk.query.QLjkCollection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LjkCollectionService {

    @Autowired
    lateinit var ljkCollectionDao: LjkCollectionDao

    fun queryLjkCollectionByConditions(qLjkCollection: QLjkCollection): List<LjkCollection> {
        return ljkCollectionDao.queryLjkCollectionByConditions(qLjkCollection)
    }
}
