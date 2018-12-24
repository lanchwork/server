package com.seal.ljk.common

object Constant {

    // importer接口地址
    val IMPORTER_URL = "http://39.104.136.10:6526/api/txs/signed"
    
    val SEAL: String = "seal"
    
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
