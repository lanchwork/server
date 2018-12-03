package com.seal.ljk.service

import com.seal.ljk.dao.*
import com.seal.ljk.model.*
import com.seal.ljk.query.QLoan
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LoanService {

    @Autowired
    lateinit var loanDao: LoanDao

    @Autowired
    lateinit var settlementDao: SettlementDao

    @Autowired
    lateinit var investDetailDao: InvestDetailDao

    fun getLoanListByInvestNo(qLoan: QLoan): LoanList {
        val resultList = LoanList()
        resultList.list = loanDao.getLoanListByInvestNo(qLoan)
        var investNo:String=qLoan.investNo

        //已结算金额settledAmt计算
        resultList.settledAmt=settlementDao.getApplySettleAmtSum(investNo)

        //未结算本金
        var investAmt= investDetailDao.getUnsettledPrincipal(investNo)
        //放款已回款分润统计
        var investorProfitSum =loanDao.getInvestorProfitAndStatus2Sum(investNo)
        //回款中的本金统计
        var repayAmtSum =loanDao.getRepayAmtAndStatus1Sum(investNo)

        //可结算金额settleableAmt计算
        resultList.settleableAmt=investorProfitSum.add(investAmt).subtract(repayAmtSum)

        //未结算金额unsettledAmt计算
        resultList.unsettledAmt=investorProfitSum.add(investAmt).add(repayAmtSum)
        return resultList
    }

    fun queryInvestLoanByConditions(qLoan: QLoan): List<InvestLoan> {
        return loanDao.queryInvestLoanByConditions(qLoan)
    }


}