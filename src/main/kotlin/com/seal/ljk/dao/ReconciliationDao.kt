package com.seal.ljk.dao

import com.seal.ljk.model.Reconciliation
import com.seal.ljk.provider.ReconciliationProvider
import com.seal.ljk.query.QReconciliation
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.SelectProvider
import org.springframework.stereotype.Repository

@Repository
interface ReconciliationDao {

    @Select("select * from reconciliation")
    fun getAllReconciliation(): List<Reconciliation>

    @Select("select * from reconciliation where partner_Id = #{partnerId}")
    fun getReconciliationById(@Param("partnerId") partnerId: String): Reconciliation

    @Select("select * from reconciliation limit #{currentPage}, #{pageSize}")
    fun getReconciliationList(@Param("currentPage") currentPage: Int, @Param("pageSize") pageSize: Int): List<Reconciliation>

    @SelectProvider(type = ReconciliationProvider::class, method = "getReconciliationByCondition")
    fun getReconciliationByCondition(qReconciliation: QReconciliation): List<Reconciliation>

    /**
     * 统计该合作方收到投资人的投资金额总和，即合作方的收款金额
     */
    @Select("select sum(invest_amt) as rcv_amt  from invest_detail where partner_id=#{partnerId}")
    fun sumInvestAmtByPartnerId(partnerId: String): Map<String, Any>

    /**
     * 统计该合作方在前一天的放款金额总和
     */
    @Select("select sum(actual_loan_amt) as loan_amt " +
            "from loan " +
            "where invest_no in (select invest_no from invest_detail where partner_id =#{partnerId}) " +
            "and loan_time>=date_format(date(now())-1,'%Y-%m-%d %H:%i:%s') " +
            "and loan_time<date_format(date(now()),'%Y-%m-%d %H:%i:%s')")
    fun sumLoanAmtByPartnerId(partnerId: String): Map<String, Any>

    /**
     * 统计所有投资人对该合作方发起的结算金额、投资人分润、seal分润
     */
    @Select("select sum(apply_settle_amt) as settle_amt,sum(investor_profit) as invest_total_amt,sum(seal_profit) as seal_total_profit " +
            "from settlement where partner_id=#{partnerId}")
    fun sumSettlementByPartnerId(partnerId: String): Map<String, Any>

    /**
     * 统计该合作方未结算本金之和
     */
    @Select("select sum(unsettled_principal) as unsettled_principal from invest_detail where partner_id=#{partnerId}")
    fun sumUnsettledPrincipalByPartnerId(partnerId: String): Map<String, Any>

    /**
     * 统计自上次结算后还款的总分润
     */
    @Select("select sum(l.investor_profit) as investor_profit " +
            "from loan as l " +
            "join " +
            "(select invest_no,max(settle_time) as settle_time " +
            " from settlement " +
            " where partner_id = '123' " +
            " group by invest_no) as g " +
            "on l.invest_no=g.invest_no and l.repay_time>settle_time")
    fun sumProfitByPartnerId(partnerId: String):Map<String, Any>
}