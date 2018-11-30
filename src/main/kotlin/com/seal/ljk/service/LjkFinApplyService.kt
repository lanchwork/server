package com.seal.ljk.service

import com.seal.ljk.dao.LjkFinApplyDao
import com.seal.ljk.model.LjkFinApply
import com.seal.ljk.query.QLjkFinApply
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal


/**
 * @program: si-server
 *
 * @description: 链金控融资信息
 *
 * @author: tingyx
 *
 * @create: 2018-11-30 14:19
 **/
@Service
class LjkFinApplyService {

    @Autowired
    lateinit var ljkFinApplyDao: LjkFinApplyDao

    fun queryFinApplyByKey(channelFinApplyId: String): List<LjkFinApply>{
        return ljkFinApplyDao.queryFinApplyByKey(channelFinApplyId)
    }

    fun queryFinApply(qLjkFinApply: QLjkFinApply): List<Map<String,String>>{
        val ljkFinApplyIdList = ljkFinApplyDao.queryFinApply(qLjkFinApply)
        val resultList = mutableListOf<Map<String,String>>()
        ljkFinApplyIdList.forEach {
            val updateTime = it["update_time"].toString() //上链时间
            val finApplyId = it["fin_apply_id"].toString() //融资申请编号
            val applyDate = it["apply_date"].toString()           //申请时间
            val productName = it["product_name"].toString()       //产品名称
            val channelCustomerId = it["channel_customer_id"].toString()//借款人编号
            val interestRate = it["interest_rate"].toString()     //利率

            val loanMap = ljkFinApplyDao.sumLoanAmtByFinApplyId(finApplyId)
            val loanDate = loanMap?.get("loan_date").toString()      //放款时间
            val expireDate = loanMap?.get("expire_date").toString()  //到期时间
            val loanAmt = loanMap?.get("loan_amt").toString() //放款金额

            val repayMap = ljkFinApplyDao.sumRepayAmtByFinApplyId(finApplyId)
            val repayAmt = repayMap?.get("repay_amt").toString()      //还款金额

            val currentStateMap = ljkFinApplyDao.queryCurrentStateByFinApplyId(finApplyId)
            val currentState = currentStateMap?.get("current_state").toString()      //融资状态

            val overdueMap = ljkFinApplyDao.sumOverdueAmtByFinApplyId(finApplyId)
            val overdueDays = overdueMap?.get("overdue_days").toString()     //逾期天数
            val overdueAmt = overdueMap?.get("overdue_amt").toString()       //逾期金额

            val unRepayAmt = (BigDecimal(loanAmt) - BigDecimal(repayAmt)).toString()

            resultList.add(mapOf(
                    "updateTime" to updateTime,
                    "finApplyId" to finApplyId,
                    "applyDate" to applyDate,
                    "productName" to productName,
                    "channelCustomerId" to channelCustomerId,
                    "interestRate" to interestRate,
                    "loanDate" to loanDate,
                    "expireDate" to expireDate,
                    "loanAmt" to loanAmt,
                    "repayAmt" to repayAmt,
                    "currentState" to currentState,
                    "overdueDays" to overdueDays,
                    "overdueAmt" to overdueAmt,
                    "unRepayAmt" to unRepayAmt)
            )
        }
        return resultList
    }
}

