package com.seal.ljk.dao

import com.seal.ljk.model.InvestLoan
import com.seal.ljk.model.Loan
import com.seal.ljk.provider.LoanProvider
import com.seal.ljk.query.QLoan
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.SelectProvider
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
interface LoanDao {

    @SelectProvider(type = LoanProvider::class, method = "getLoanListByInvestNo")
    fun getLoanListByInvestNo(qLoan: QLoan): List<Loan>

    @SelectProvider(type = LoanProvider::class, method = "queryInvestLoanByConditions")
    fun queryInvestLoanByConditions(qLoan: QLoan): List<InvestLoan>

    @Select("select sum(investor_profit) FROM loan  where invest_no=#{investNo} AND status=2")
    fun getInvestorProfitAndStatus2Sum(investNo: String): BigDecimal

    @Select("select sum(repay_amt) FROM loan  where invest_no=#{investNo} AND status=1")
    fun getRepayAmtAndStatus1Sum(investNo: String): BigDecimal

    @Select("select investor_profit, seal_profit from loan where invest_no=#{investNo}")
    fun getProfit(investNo: String): Map<String, BigDecimal>
}