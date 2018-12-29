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
        var buyNumber: BigDecimal = BigDecimal.ZERO,

        /**
     * 购买金额
     */
        var buyAmount: BigDecimal = BigDecimal.ZERO,

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
         * token名
         */
        var tokenName:String = "",
        /**
         * 合约账户
         */
        var contractAccount:String = "",
        /**
         * 单价
         */
        var price : BigDecimal = BigDecimal.ZERO
) : Base(), IVerify {

    override fun verify() {
        this.apply {
            "投资项目id 不能为空" using (this.itemId.isNotEmpty())
            "区号 不能为空" using (this.areaCode.isNotEmpty())
            "联系电话 不能为空" using (this.mobile.isNotEmpty())
            "购买数量 不能小于0" using (BigDecimal.ZERO.compareTo(this.buyNumber)==-1)
            "购买金额 不能小于0" using (BigDecimal.ZERO.compareTo(this.buyAmount)==-1)
            "状态 不能为空" using (this.status !=null)
            "备注 不能为空" using (this.remarks.isNotEmpty())
            "类型 不能为空" using (this.type !=null)
        }
    }
}


