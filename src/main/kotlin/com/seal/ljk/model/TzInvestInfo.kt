package com.seal.ljk.model

import com.seal.ljk.common.using
import com.seal.ljk.base.PrimaryKey
import java.math.BigDecimal

/**
 * <p>
 * 投资信息 数据类
 * </p>
 * @author lanch
 * @since 2018-12-28
 */
data class TzInvestInfo(

        @PrimaryKey
        var id: String = "",

        /**
         * 投资项目id
         */
        var itemId: String = "",

        /**
         * 区号
         */
        var areaCode: String = "",

        /**
         * 联系电话
         */
        var mobile: String = "",

        /**
         * 购买数量
         */
        var buyNumber: BigDecimal? = null,

        /**
         * 购买金额
         */
        var buyAmount: BigDecimal? = null,

        /**
         * 状态
         */
        var status: Char? = null,

        /**
         * 备注
         */
        var remarks: String = "",

        /**
         * 类型
         */
        var type: Char? = null,


        /**
         * 下单时的价格
         */
        var currPrice: BigDecimal? = null,

        /**
         * 主链账号
         */
        var account: String = "",

        /**
         * 语言
         */
        var lang: String = ""
) : Base(), IVerify {

    /**
     * 项目管理表中 token名
     */
    var tokenName: String = ""

    override fun verify() {
        "投资项目id 不能为空" using (itemId.isNotEmpty())
        "区号 不能为空" using (areaCode.isNotEmpty())
        "联系电话 不能为空" using (mobile.isNotEmpty())
        "购买数量 不能小于0" using (buyNumber != null && BigDecimal.ZERO.compareTo(buyNumber) == -1)
        "购买金额 不能小于0" using (buyAmount != null && BigDecimal.ZERO.compareTo(buyAmount) == -1)
        "下单时价格 不能小于0" using (currPrice != null && BigDecimal.ZERO.compareTo(currPrice) == -1)
        "状态 不能为空" using (status != null)
        "主链账号 不能为空" using (account.isNotEmpty())
        "类型 不能为空" using (type != null)
    }
}


