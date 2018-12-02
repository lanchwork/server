package com.seal.ljk.dao

import com.seal.ljk.model.Reconciliation
import com.seal.ljk.provider.ReconciliationProvider
import com.seal.ljk.query.QReconciliation
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.SelectProvider
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
interface ReconciliationDao {

    @Select("select * from lc_reconciliation")
    fun getAllReconciliation(): List<Reconciliation>

    @Select("select * from lc_reconciliation where partner_Id = #{partnerId}")
    fun getReconciliationById(@Param("partnerId") partnerId: String): Reconciliation

    @Select("select * from lc_reconciliation limit #{currentPage}, #{pageSize}")
    fun getReconciliationList(@Param("currentPage") currentPage: Int, @Param("pageSize") pageSize: Int): List<Reconciliation>

    @SelectProvider(type = ReconciliationProvider::class, method = "getReconciliationByCondition")
    fun getReconciliationByCondition(qReconciliation: QReconciliation): List<Reconciliation>

    @Insert("insert into lc_reconciliation(reconciliation_id, partner_id, user_no, statistics_date, rcv_amt, loan_amt, settle_amt, balance, investor_total_profit, seal_total_profit, " +
            "result, create_date, create_user, update_date, update_user, remark) " +
            "values(#{reconciliation.reconciliationId},#{reconciliation.partnerId},#{reconciliation.userNo},#{reconciliation.statisticsDate},#{reconciliation.rcvAmt},#{reconciliation.loanAmt}, " +
            "#{reconciliation.settleAmt},#{reconciliation.balance},#{reconciliation.investorTotalProfit},#{reconciliation.sealTotalProfit},#{reconciliation.result}, " +
            "#{reconciliation.createDate}, #{reconciliation.createUser}, #{reconciliation.updateDate}, #{reconciliation.updateUser}, #{reconciliation.remark})")
    fun create(@Param("reconciliation") reconciliation: Reconciliation): Int

    /**
     * 统计该合作方收到投资人的投资金额总和，即合作方的收款金额
     */
    @Select("select sum(invest_amt) as rcv_amt  from lc_invest_detail where partner_id=#{partnerId}")
    fun sumInvestAmtByPartnerId(partnerId: String): Map<String, BigDecimal>?

    /**
     * 统计该合作方在前一天的放款金额总和
     */
    @Select("select sum(actual_loan_amt) as loan_amt " +
            "from lc_loan " +
            "where invest_no in (select invest_no from lc_invest_detail where partner_id =#{partnerId}) " +
            "and loan_time>=date_format(date(now())-1,'%Y-%m-%d %H:%i:%s') " +
            "and loan_time<date_format(date(now()),'%Y-%m-%d %H:%i:%s')")
    fun sumLoanAmtByPartnerId(partnerId: String): Map<String, BigDecimal>?

    /**
     * 统计所有投资人对该合作方发起的结算金额、投资人分润、seal分润
     */
    @Select("select sum(apply_settle_amt) as settle_amt,sum(investor_profit) as investor_total_profit,sum(seal_profit) as seal_total_profit " +
            "from lc_settlement where partner_id=#{partnerId}")
    fun sumSettlementByPartnerId(partnerId: String): Map<String, BigDecimal>?

    /**
     * 统计该合作方未结算本金之和
     */
    @Select("select sum(unsettled_principal) as unsettled_principal from lc_invest_detail where partner_id=#{partnerId}")
    fun sumUnsettledPrincipalByPartnerId(partnerId: String): Map<String, BigDecimal>?

    /**
     * 统计自上次结算后还款的总分润
     */
    @Select("select sum(l.investor_profit) as investor_profit " +
            "from lc_loan as l " +
            "join " +
            "(select invest_no,max(settle_time) as settle_time " +
            " from lc_settlement " +
            " where partner_id =#{partnerId} " +
            " group by invest_no) as g " +
            "on l.invest_no=g.invest_no and l.repay_time>settle_time")
    fun sumProfitByPartnerId(partnerId: String): Map<String, BigDecimal>?
}