package com.seal.ljk.model

import java.util.Date
import com.seal.ljk.model.Base
import com.seal.ljk.common.using
import com.seal.ljk.base.PrimaryKey
import java.math.BigDecimal

/**
 * <p>
 * 总收益 数据类
 * </p>
 * @author chenjh
 * @since 2018-12-28
 */
data class TzRevenue(

        @PrimaryKey
        var id: String = "",

        /**
         * 投资项目id
         */
        var itemId: String = "",

        /**
         * 总收益
         */
        var totalRevenue: BigDecimal? = null,
        /**
         * 每份收益
         */
        var preRevenue: BigDecimal? = null,

        /**
         * 收益类型,0租金分红,1出售分润
         */
        var revenueType: String = "",

        /**
         * 日期
         */
        var revenueDate: Date? = null,

        /**
         * 状态，0未支付，1已支付
         */
        var status: String = ""

) : Base(), IVerify {

    var revenueDateBegin: Date? = null
    var revenueDateEnd: Date? = null
    var tokenName: String? = null
    var tokenShortName: String? = null
    var account: String? = null
    var tokenNo: String? = null

    override fun verify() {
        this.apply {
            "投资项目id 不能为空" using (this.itemId.isNotEmpty())
            "总收益 不能为空" using (this.totalRevenue != null)
            "每份收益 不能为空" using (this.preRevenue != null)
            "收益类型 不能为空" using (this.revenueType.isNotEmpty())
            "日期 不能为空" using (this.revenueDate != null)
            "状态 不能为空" using (this.status.isNotEmpty())
        }
    }
}


