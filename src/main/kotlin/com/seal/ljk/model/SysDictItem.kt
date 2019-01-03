package com.seal.ljk.model

import com.seal.ljk.model.Base
import com.seal.ljk.common.using
import com.seal.ljk.base.PrimaryKey

/**
 * <p>
 *  数据项列表 数据类
 * </p>
 * @author lanch
 * @since 2019-01-03
 */
data class SysDictItem(

    @PrimaryKey
    var id: String = "",

    /**
     * 真实值
     */
    var value: String = "",

    /**
     * 显示值
     */
    var showVal: String = "",

    /**
     * 描述
     */
    var remark: String = "",

    /**
     * 字典id
     */
    var typeId: String = "",

    /**
     * 项目排序
     */
    var sort: Int? = null,

    /**
     * 删除标识
     */
    var delFlag: String = ""
) : Base(), IVerify {

    override fun verify() {
        this.apply {
            "真实值 不能为空" using (this.value.isNotEmpty())
            "显示值 不能为空" using (this.showVal.isNotEmpty())
            "描述 不能为空" using (this.remark.isNotEmpty())
            "字典id 不能为空" using (this.typeId.isNotEmpty())
        }
    }
}


