package com.seal.ljk.dao

import com.seal.ljk.model.LjkRepay
import com.seal.ljk.provider.LjkRepayProvider
import com.seal.ljk.query.QLjkRepay
import org.apache.ibatis.annotations.SelectProvider
import org.springframework.stereotype.Repository

@Repository
interface LjkRepayDao {

    @SelectProvider(type = LjkRepayProvider::class, method = "queryLjkRepayByConditions")
    fun queryByConditions(qLjkRepay: QLjkRepay): List<LjkRepay>

}
