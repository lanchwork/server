package com.seal.ljk.service

import com.seal.ljk.dao.*
import com.seal.ljk.model.*
import com.seal.ljk.query.QLoan
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal

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

        //已结算金额settledAmt=申请结算金额apply_settle_amt(每笔投资)
        resultList.settledAmt=settlementDao.getApplySettleAmtSum(investNo)
        var investAmt = BigDecimal(0)
        if(resultList.settledAmt!=null){
            //没查询到结算记录 则当前本金=投资总金额investAmt
            investAmt= investDetailDao.getInvestAmt(investNo)
        }else{
            // 查询到结算记录 则需要根据上次结算时间


        }
        //可结算金额settleableAmt=放款已回款分润investorProfit status=2 (每笔投资)+当前本金-回款中的本金repayAmt status=1(每笔投资)
        var investorProfit =loanDao.getInvestorProfitAndStatus2Sum(investNo)
        var repayAmt =loanDao.getRepayAmtAndStatus1Sum(investNo)
        resultList.settleableAmt=investorProfit.add(investAmt).subtract(repayAmt)

        //未结算金额unsettledAmt=当前本金+放款已回款分润(每笔投资)+回款中的本金 (每笔投资)
        resultList.settleableAmt=investorProfit.add(investAmt).add(repayAmt)
        return resultList
    }

    fun queryInvestLoanByConditions(qLoan: QLoan): List<InvestLoan> {
        return loanDao.queryInvestLoanByConditions(qLoan)
    }


}