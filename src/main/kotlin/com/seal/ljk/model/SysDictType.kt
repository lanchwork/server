package com.seal.ljk.model

import com.seal.ljk.common.using
import com.seal.ljk.base.PrimaryKey

/**
 * <p>
 * 数据字典类型 数据类
 * </p>
 * @author tingyx
 * @since 2019-01-03
 */
data class SysDictType(

    @PrimaryKey
    var id: String = "",

    /**
     * 编码
     */
    var code: String = "",

    /**
     * 字典名称
     */
    var name: String = "",

    /**
     * 删除标识
     */
    var delFlag: String = "",

    /**
     * 描述
     */
    var remark: String = ""
) : Base(), IVerify {

    override fun verify() {
        "编码 不能为空" using (code.isNotEmpty())
        "字典名称 不能为空" using (name.isNotEmpty())
        "描述 不能为空" using (remark.isNotEmpty())
    }
}


