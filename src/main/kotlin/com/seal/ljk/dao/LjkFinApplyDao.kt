package com.seal.ljk.dao

import com.seal.ljk.model.LjkFinApply
import com.seal.ljk.provider.LjkFinApplyProvider
import com.seal.ljk.query.QLjkFinApply
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.SelectProvider
import org.springframework.stereotype.Repository

@Repository
interface LjkFinApplyDao {

    /**
     * 链金控 按条件查询满足要求的所有融资信息的融资统计信息
     */
    @SelectProvider(type = LjkFinApplyProvider::class, method = "queryFinApplyId")
    fun queryFinApply(qLjkFinApply: QLjkFinApply): List<Map<String,Any>>

    @Select("select * from ljk_fin_apply where channel_fin_apply_id=#{channelFinApplyId}")
    fun queryFinApplyByKey(channelFinApplyId: String): List<LjkFinApply>

    /**
     * 统计该融资申请编号的放款总金额
     */
    @Select("select loan_date,expire_date,sum(actual_release_amt) as loan_amt " +
            "from ljk_loan " +
            "where channel_fin_apply_id=#{finApplyId}")
    fun sumLoanAmtByFinApplyId(finApplyId: String): Map<String,Any>?

    /**
     * 统计该融资申请编号的还款总金额
     */
    @Select("select sum(this_repay_principal) repay_amt " +
            "from ljk_repay " +
            "where channel_fin_apply_id=#{finApplyId}")
    fun sumRepayAmtByFinApplyId(finApplyId: String): Map<String,Any>?

    /**
     * 查询该融资申请编号的最新融资状态
     */
    @Select("select a.current_state as current_state from ljk_status_change as a right join " +
            "(select business_objectId,max(updateTime) as max_time " +
            "from ljk_status_change " +
            "where business_objectId=#{finApplyId}) as b " +
            "on a.business_objectId=b.business_objectId and a.updateTime=b.max_time")
    fun queryCurrentStateByFinApplyId(finApplyId: String): Map<String,Any>?

    /**
     * 统计该融资申请编号的逾期金额
     */
    @Select("select overdue_days,sum(overdue_amt) as overdue_amt " +
            "from ljk_overdue " +
            "where channel_fin_apply_id=#{finApplyId}")
    fun sumOverdueAmtByFinApplyId(finApplyId: String): Map<String,Any>?

}