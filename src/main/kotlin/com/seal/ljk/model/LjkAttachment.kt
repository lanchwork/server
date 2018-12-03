package com.seal.ljk.model


/*
* 附件dto
* */
data class LjkAttachment(
        var attachmentId: String = "",              // 附件编号
        var channelMark: String = "",                 // 渠道标识
        var channelAttachmentId: String = "",       // 渠道附件编号
        var generateDate: String = "",              // 生成日期
        var attachmentType: String = "",           // 附件类型
        var fileType: String = "",                 // 文档类型
        var attachmentUrl: String = "",            // 附件路径

        var remark: String = "",                    // 备注
        var remark1: String = "",
        var remark2: String = "",
        var remark3: String = "",
        var remark4: String = "",
        var remark5: String = ""
)