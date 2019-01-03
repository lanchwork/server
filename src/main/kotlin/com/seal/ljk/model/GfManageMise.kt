package com.seal.ljk.model

import com.seal.ljk.model.Base
import com.seal.ljk.common.using
import com.seal.ljk.base.PrimaryKey

/**
 * <p>
 * GF管理员 数据类
 * </p>
 * @author kangxj
 * @since 2019-01-03
 */
data class GfManageMise(

    @PrimaryKey
    var id: String = "",
    /**
     * 编号
     */
    var gfCode: String = "",

    /**
     * 钱包地址
     */
    var address: String = "",

    /**
     * 备注
     */
    var remark: String = ""
) : Base(), IVerify {

    override fun verify() {
        this.apply {
            "编号 不能为空" using (this.gfCode.isNotEmpty())
            "钱包地址 不能为空" using (this.address.isNotEmpty())
        }
    }
}


