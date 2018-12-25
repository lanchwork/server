package com.seal.ljk.model

import com.baomidou.mybatisplus.annotation.TableField
import com.seal.ljk.base.PrimaryKey
import com.seal.ljk.common.Constant
import com.seal.ljk.model.Base
import com.seal.ljk.common.using

/**
 * 用户表
 * @author chenjh
 * @since 2018-12-25
 */
data class SysUser(

    /**
     * 主键id
     */
    @PrimaryKey
    var id: String = "",

    /**
     * 用户名
     */
    var username: String = "",

    /**
     * 初始明文密码
     */
    var initPass: String = "",

    /**
     * 密文密码
     */
    var password: String = "",

    /**
     * 渠道标识
     */
    var channelMark: String = "",

    /**
     * 姓名
     */
    var name: String = "",

    /**
     * 手机号
     */
    var phone: String = "",

    /**
     * 邮箱
     */
    var email: String = "",

    /**
     * 是否开启   0为是 1为否
     */
    var openFlag: String = ""
) : Base(), IVerify {

    override fun verify() {
        this.apply {
            "用户名 不能为空" using (this.username.isNotEmpty())
            "初始密码 不能为空" using (this.initPass.isNotEmpty())
            "渠道标识 不能为空" using (this.channelMark.isNotEmpty())
            "姓名 不能为空" using (this.name.isNotEmpty())
            "手机号 不能为空" using (this.phone.isNotEmpty())
            "邮箱 不能为空" using (this.email.isNotEmpty())
            "是否开启   0为是 1为否 不能为空" using (this.openFlag.isNotEmpty())
        }
    }

    fun isSeal(): Boolean {
        return Constant.SEAL == channelMark
    }
}


