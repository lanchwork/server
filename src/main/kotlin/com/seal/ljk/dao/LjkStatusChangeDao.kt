package com.seal.ljk.dao

import com.seal.ljk.model.LjkStatusChange
import com.seal.ljk.provider.LjkStatusChangeProvider
import com.seal.ljk.query.QLjkStatusChange
import org.apache.ibatis.annotations.SelectProvider
import org.springframework.stereotype.Repository

@Repository
interface LjkStatusChangeDao {

    @SelectProvider(type = LjkStatusChangeProvider::class, method = "queryLjkStatusChangeByConditions")
    fun queryByConditions(qLjkStatusChange: QLjkStatusChange): List<LjkStatusChange>

}
