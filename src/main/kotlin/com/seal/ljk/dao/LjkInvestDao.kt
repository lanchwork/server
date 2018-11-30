package com.seal.ljk.dao

import com.seal.ljk.model.LjkInvest
import com.seal.ljk.provider.LjkInvestProvider
import com.seal.ljk.query.QLjkInvest
import org.apache.ibatis.annotations.SelectProvider
import org.springframework.stereotype.Repository

@Repository
interface LjkInvestDao {

    @SelectProvider(type = LjkInvestProvider::class, method = "queryLjkInvestByConditions")
    fun queryByConditions(qLjkInvest: QLjkInvest): List<LjkInvest>

}
