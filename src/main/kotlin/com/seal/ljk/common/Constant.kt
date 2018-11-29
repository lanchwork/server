package com.seal.ljk.common

object Constant {

    // 交易类型
    object TRANS_TYPE {
        const val LOAN = "01"
        const val INVEST = "02"
        const val REPAY = "03"
        const val PAYBACK = "04"
    }

    // 结算状态
    object SETTLE_STATUS {
        const val APPLY = 1
        const val SETTLED = 2
    }

    // 投资状态
    object INVEST_STATUS {
        const val FAIL = 0
        const val SUCCESS = 1
        const val SETTLED = 2
    }

}