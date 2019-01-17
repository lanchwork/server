package com.seal.ljk.model

import com.seal.ljk.model.Base
import com.seal.ljk.common.using
import com.seal.ljk.base.PrimaryKey

/**
 * <p>
 *  数据类
 * </p>
 * @author lanch
 * @since 2019-01-16
 */
data class TzMessageInfo(

    @PrimaryKey
    var id: String = "",

    /**
     * 通知类型
     */
    var type: String = "",

    /**
     * 通知内容
     */
    var content: String = "",

    /**
     * 是否已读
     */
    var readStatus: String = "",

    /**
     * 手机号
     */
    var mobile: String = "",

    /**
     * 主链account
     */
    var account: String = "",

    /**
     * 通知标题
     */
    var title: String = "",

    /**
     * 关联tokenid
     */
    var itemId: String = ""
) : Base(), IVerify {

    override fun verify() {
        " 不能为空" using (id.isNotEmpty())
        "通知类型 不能为空" using (type.isNotEmpty())
        "通知内容 不能为空" using (content.isNotEmpty())
        "是否已读 不能为空" using (readStatus.isNotEmpty())
        "手机号 不能为空" using (mobile.isNotEmpty())
        "主链account 不能为空" using (account.isNotEmpty())
        "通知标题 不能为空" using (title.isNotEmpty())
        "关联tokenid 不能为空" using (itemId.isNotEmpty())
    }
}


