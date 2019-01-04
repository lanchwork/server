package com.seal.ljk.model

import com.seal.ljk.base.PrimaryKey
import com.seal.ljk.model.Base
import com.seal.ljk.common.using

/**
 * 菜单表
 * @author chenjh
 * @since 2018-12-25
 */
data class SysMenu(

    /**
     * 主键id
     */
    @PrimaryKey
    var id: String = "",

    /**
     * 父菜单ID，一级菜单为0
     */
    var parentId: String = "",

    /**
     * 菜单名称
     */
    var menuName: String = "",

    /**
     * 菜单对应的页面url
     */
    var url: String = "",

    /**
     * 显示顺序
     */
    var sort: Int? = null,

    /**
     * 是否有效
     */
    var flag: Int? = null,
    /**
     * 类型，0顶级菜单，1侧边菜单，2按钮
     */
    var type: Int? = null,

    /**
     * 菜单对应的图标
     */
    var icon: String = "",

    /**
     * 根据合作方类型过滤菜单（如：1,2)
     */
    var partnerTypes: String = ""

) : Base(), IVerify {

    var children: Array<SysMenu>? = null
    var roleIds: Array<String>? = null
    var checked: String? = null

    override fun verify() {
        this.apply {
            "父菜单ID 不能为空" using (this.parentId.isNotEmpty())
            "菜单名称 不能为空" using (this.menuName.isNotEmpty())
//            "菜单对应的页面url 不能为空" using (this.url.isNotEmpty())
            "显示顺序 不能为空" using (this.sort != null)
            "是否有效 不能为空" using (this.flag != null)
        }
    }
}


