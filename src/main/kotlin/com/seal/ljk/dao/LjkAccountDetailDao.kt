package com.seal.ljk.dao

import com.seal.ljk.model.LjkAccountDetail
import com.seal.ljk.provider.LjkAccountDetailProvider
import com.seal.ljk.query.QLjkAccountDetail
import org.apache.ibatis.annotations.SelectProvider
import org.springframework.stereotype.Repository

@Repository
interface LjkAccountDetailDao {

    @SelectProvider(type = LjkAccountDetailProvider::class, method = "queryLjkAccountDetailByConditions")
    fun queryByConditions(qLjkAccountDetail: QLjkAccountDetail): List<LjkAccountDetail>

}
