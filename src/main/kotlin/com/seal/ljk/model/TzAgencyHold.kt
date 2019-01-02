package com.seal.ljk.model

import com.seal.ljk.model.Base
import com.seal.ljk.common.using
import com.seal.ljk.base.PrimaryKey
import java.math.BigDecimal

/**
 * <p>
 *  数据类
 * </p>
 * @author kangxj
 * @since 2019-01-02
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
    var tokenNumber: BigDecimal? = null,

        /**
     * 单价
     */
    var price: BigDecimal? = null,

        /**
     * account账户
     */
    var account: String = "",

        /**
     * 区号
     */
    var areaCode: String = "",

        /**
     * 类型(1代持转入2代持转出)
     */
    var type: String = "",

        /**
     * 当前持有量 
     */
    var currentHoldings: BigDecimal? = null,

        /**
     * 备注
     */
    var remark: String = "",

        /**
     * token名称
     */
    var tokenName: String = "",

        /**
     * 账户(Seal代持)
     */
    var sealAccount: String = ""
) : Base(), IVerify {

    override fun verify() {
        this.apply {
            "用户手机号不能为空" using (this.mobile.isNotEmpty())
            "token数量不能为空" using (BigDecimal.ZERO.compareTo(this.tokenNumber)==-1)
            "单价不能为空" using (BigDecimal.ZERO.compareTo(this.price)==-1)
            "区号不能为空" using (this.areaCode.isNotEmpty())
            "类型(1代持转入2代持转出) 不能为空" using (this.type.isNotEmpty())
            "当前持有量不能为空" using (BigDecimal.ZERO.compareTo(this.currentHoldings)==-1)
            "token名称不能为空" using (this.tokenName.isNotEmpty())
            "账户(Seal代持)不能为空" using (this.sealAccount.isNotEmpty())
        }
    }
}


