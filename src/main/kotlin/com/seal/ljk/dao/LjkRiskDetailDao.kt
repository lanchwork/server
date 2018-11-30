package com.seal.ljk.dao

import com.seal.ljk.model.LjkRiskDetail
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository

@Repository
interface LjkRiskDetailDao {

    /**
     * 链金控风控详细信息
     */
    @Select("select * from ljk_risk_detail where risk_calculate_id=#{riskCalculateId}")
    fun getRiskDetailByKey(riskCalculateId: String): List<LjkRiskDetail>
}