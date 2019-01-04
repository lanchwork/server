package com.seal.ljk.model

import com.seal.ljk.common.using
import com.seal.ljk.base.PrimaryKey

/**
 * <p>
 * 管理员数据类
 * </p>
 * @author kangxj
 * @since 2019-01-04
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
    var remark: String = "",

    /**
     * 功能模块(1 GF管理 2 收益管理 3高级转账) 以逗号隔开
     */
    var functionalModule: String = ""
) : Base(), IVerify {

    override fun verify() {
        this.apply {
            "钱包地址 不能为空" using (this.address.isNotEmpty())
            "功能模块 不能为空" using (this.functionalModule.isNotEmpty())
        }
    }
}


