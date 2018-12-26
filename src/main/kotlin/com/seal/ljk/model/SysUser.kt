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
    var openFlag: String = "",
    /**
     * 用户类型 0超级管理员用户 1合作方管理员，2普通用户
     * 管理员用户只能由 seal 创建及删除
     */
    var userType: String = ""

) : Base(), IVerify {

    companion object {
        val USER_TYPE_SUPER = "0"
        val USER_TYPE_ADMIN = "1"
        val USER_TYPE_NORMAL = "2"
    }

    var partner: SysPartner? = null

    override fun verify() {
        this.apply {
            "用户名 不能为空" using (this.username.isNotEmpty())
            "初始密码 不能为空" using (this.initPass.isNotEmpty())
            "渠道标识 不能为空" using (this.channelMark.isNotEmpty())
            "姓名 不能为空" using (this.name.isNotEmpty())
            "手机号 不能为空" using (this.phone.isNotEmpty())
            "邮箱 不能为空" using (this.email.isNotEmpty())
            "是否开启 不能为空" using (this.openFlag.isNotEmpty())
        }
    }

    fun isSeal(): Boolean {
        return Constant.SEAL == channelMark
    }

    fun isAdmin(): Boolean {
        return USER_TYPE_SUPER == userType || USER_TYPE_ADMIN == userType
    }
}


