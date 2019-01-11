package com.seal.ljk.model

import com.seal.ljk.model.Base
import com.seal.ljk.common.using
import com.seal.ljk.base.PrimaryKey

/**
 * <p>
 * banner 数据类
 * </p>
 * @author lanch
 * @since 2019-01-03
 */
data class SysBanner(
        /**
         * id
         */
        @PrimaryKey
        var id: String = "",
        /**
         * 标题
         */
        var title: String = "",


        /**
         * 路径
         */
        var imgPath: String = "",

        /**
         * 跳转地址
         */
        var linkUrl: String = "",

        /**
         * 业务类型，0:通证
         */
        var type: String = "",

        /**
         * 状态，1启用，0禁用
         */
        var status: String = "",
        /**
         * 语言，ch 中文，en 英文
         */
        var lang: String = ""
) : Base(), IVerify {

    override fun verify() {
        "标题 不能为空" using (this.title.isNotEmpty())
        "路径 不能为空" using (this.imgPath.isNotEmpty())
        type = type.ifEmpty { "0" }
        status = status.ifEmpty { "1" }
    }
}


