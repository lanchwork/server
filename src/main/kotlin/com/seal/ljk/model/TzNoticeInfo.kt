package com.seal.ljk.model

import com.seal.ljk.model.Base
import com.seal.ljk.common.using
import com.seal.ljk.base.PrimaryKey

/**
 * <p>
 * 公告 数据类
 * </p>
 * @author chenjh
 * @since 2018-12-28
 */
data class TzNoticeInfo(

    @PrimaryKey
    var id: String = "",

    /**
     * 公告标题
     */
    var noticeTitle: String = "",

    /**
     * 公告内容
     */
    var noticeContent: String = "",

    /**
     * 公告类型
     */
    var type: String = "",

    /**
     * 是否启用
     */
    var usingFlag: String = "",

    var noticeTitleEn: String = "",

    var noticeContentEn: String = ""
) : Base(), IVerify {

    override fun verify() {
        this.apply {
            "公告标题 不能为空" using (this.noticeTitle.isNotEmpty())
            "公告内容 不能为空" using (this.noticeContent.isNotEmpty())
            "公告类型 不能为空" using (this.type.isNotEmpty())
            "是否启用 不能为空" using (this.usingFlag.isNotEmpty())
        }
    }
}


