package com.seal.ljk.dao

import com.seal.ljk.model.LjkOverdue
import com.seal.ljk.provider.LjkOverdueProvider
import com.seal.ljk.query.QLjkOverdue
import org.apache.ibatis.annotations.SelectProvider
import org.springframework.stereotype.Repository

@Repository
interface LjkOverdueDao {

    @SelectProvider(type = LjkOverdueProvider::class, method = "queryLjkOverdueByConditions")
    fun queryLjkOverdueByConditions(qLjkOverdue: QLjkOverdue): List<LjkOverdue>

}
