package com.seal.ljk.model

import java.math.BigDecimal

/**
 * Created by chenjh on 2019-01-04.
 */
data class TzTokenMeta(
        var id: String = "",
        var type: Int? = null,
        var info: String? = "",
        var issue_price: BigDecimal? = BigDecimal.ZERO,
        var curr_price: BigDecimal? = BigDecimal.ZERO,
        var total_shares: Long? = 0,
        var available_shares: Long? = 0,
        var owner: String? = ""
)
