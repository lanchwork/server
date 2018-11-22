package com.seal.ljk.common

object Constant {

    // 交易类型
    object TRANS_TYPE {
        const val LOAN = "01"
        const val INVEST = "02"
        const val REPAY = "03"
        const val PAYBACK = "04"
    }

    // 借款状态
    object LOAN_STATUS {
        const val PAYING = 1
        const val PAYED = 2
        const val OVERDUE = 3
        const val OVERDUEPAY = 4
    }

    // 投资状态
    object INVEST_STATUS {
        const val BACKING = 1
        const val BACKED = 2
        const val OVERDUE = 3
    }

}