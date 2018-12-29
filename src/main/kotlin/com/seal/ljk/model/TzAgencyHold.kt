package com.seal.ljk.model

import com.seal.ljk.common.using
import com.seal.ljk.base.PrimaryKey
import java.math.BigDecimal

/**
 * <p>
 * 代持 数据类
 * </p>
 * @author kangxj
 * @since 2018-12-29
 */
data class TzAgencyHold(

        @PrimaryKey
    var id: String = "",

        /**
     * 投资项目id
     */
    var itemId: String = "",

        /**
     * 用户手机号
     */
    var mobile: String = "",

        /**
     * token数量
     */
    var tokenNumber: BigDecimal = BigDecimal.ZERO,

        /**
     * 单价
     */
    var price: BigDecimal = BigDecimal.ZERO,

        /**
     * account
     */
    var account: String = "",

        /**
     * 区号
     */
    var areaCode: String = "",

        /**
     * 类型 
     */
    var type: String = "",

        /**
     * 当前持有量 
     */
    var currentHoldings: BigDecimal = BigDecimal.ZERO,

        /**
     * 备注
     */
    var remark: String = ""
) : Base(), IVerify {

    override fun verify() {
        this.apply {
            "投资项目id 不能为空" using (this.itemId.isNotEmpty())
            "用户手机号 不能为空" using (this.mobile.isNotEmpty())
            "token数量 不能小于0" using (BigDecimal.ZERO.compareTo(this.tokenNumber)==-1)
            "单价 不能小于0" using (BigDecimal.ZERO.compareTo(this.price)==-1)
            "account 不能为空" using (this.account.isNotEmpty())
            "区号 不能为空" using (this.areaCode.isNotEmpty())
            "类型  不能为空" using (this.type.isNotEmpty())
            "当前持有量  不能小于0" using (BigDecimal.ZERO.compareTo(this.currentHoldings)==-1)
        }
    }
}


