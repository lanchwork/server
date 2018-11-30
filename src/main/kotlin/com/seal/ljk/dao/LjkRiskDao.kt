package com.seal.ljk.dao

import com.seal.ljk.model.LjkRisk
import com.seal.ljk.provider.LjkRiskProvider
import com.seal.ljk.query.QLjkRisk
import org.apache.ibatis.annotations.SelectProvider
import org.springframework.stereotype.Repository

@Repository
interface LjkRiskDao {

    /**
     * 链金控风控基本信息查询
     */
    @SelectProvider(type = LjkRiskProvider::class, method = "queryRisk")
    fun queryLjkRisk(qLjkRisk: QLjkRisk): List<LjkRisk>
}