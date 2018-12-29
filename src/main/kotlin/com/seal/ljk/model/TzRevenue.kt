package com.seal.ljk.model

import java.util.Date
import com.seal.ljk.model.Base
import com.seal.ljk.common.using
import com.seal.ljk.base.PrimaryKey

/**
 * <p>
 * 总收益 数据类
 * </p>
 * @author chenjh
 * @since 2018-12-28
 */
data class TzRevenue(

    @PrimaryKey
    var id: String = "",

    /**
     * 投资项目id
     */
    var itemId: String = "",

    /**
     * 总收益
     */
    var totalRevenue: String = "",

    /**
     * 收益类型
     */
    var revenueType: String = "",

    /**
     * 日期
     */
    var revenueDate: Date? = null,

    /**
     * 状态
     */
    var status: String = "",

    /**
     * 创建时间
     */
    var createTime: Date? = null,

    /**
     * 更新时间
     */
    var updateTime: Date? = null
) : Base(), IVerify {
            var revenueDateBegin: Date? = null
            var revenueDateEnd: Date? = null
            var createTimeBegin: Date? = null
            var createTimeEnd: Date? = null
            var updateTimeBegin: Date? = null
            var updateTimeEnd: Date? = null

    override fun verify() {
        this.apply {
            " 不能为空" using (this.id.isNotEmpty())
            "投资项目id 不能为空" using (this.itemId.isNotEmpty())
            "总收益 不能为空" using (this.totalRevenue.isNotEmpty())
            "收益类型 不能为空" using (this.revenueType.isNotEmpty())
            "日期 不能为空" using (this.revenueDate != null)
            "状态 不能为空" using (this.status.isNotEmpty())
            "创建时间 不能为空" using (this.createTime != null)
            "更新时间 不能为空" using (this.updateTime != null)
        }
    }
}


