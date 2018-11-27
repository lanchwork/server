package com.seal.ljk.model

import java.math.BigDecimal
import java.util.*

class InvestLoan(
        var investorWalletAddr: String = "", //投资人钱包地址
        var partnerId: String = "", //合作方
        var partnerWalletAddr: String = "", //合作方钱包地址

        var loanId: String = "",
        var userNo: String = "", //用户标识
        var investNo: String = "", //投资编号
        var loanNo: String = "", //放款编号
        var actualLoanAmt: BigDecimal = BigDecimal(0), //实际放款金额
        var loanTime: Date = Date(), //放款时间
        var borrowerNo: String = "", //借款人编号
        var term: Int = 0, //期限
        var dayRate: BigDecimal = BigDecimal(0), //日利率（实际）
        var returnTime: Date = Date(), //应回时间
        var loanHash: String = "", //放款哈希
        var repayHash: String = "", //还款哈希
        var repayAmt: BigDecimal = BigDecimal(0), //还款金额
        var investorProfit: BigDecimal = BigDecimal(0), //投资人分润
        var sealProfit: BigDecimal = BigDecimal(0), //seal分润
        var repayTime: Date = Date(), //还款时间
        var status: Int = 0 //状态 1：回款中，2：已回款，3：逾期中；4：已垫付

): Base()