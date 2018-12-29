package com.seal.ljk.model

import java.util.Date
import com.seal.ljk.model.Base
import com.seal.ljk.common.using
import com.seal.ljk.base.PrimaryKey
import java.math.BigDecimal

/**
 * <p>
 * 投资项目 数据类
 * </p>
 * @author kangxj
 * @since 2018-12-28
 */
data class TzInvestItem(

    @PrimaryKey
    var id: String = "",

    /**
     * token名称
     */
    var tokenName: String = "",

    /**
     * token简称
     */
    var tokenShortName: String = "",

    /**
     * 图片地址
     */
    var imgPath: String = "",

    /**
     * 预期收益
     */
    var expectedVenue: BigDecimal = BigDecimal.ZERO,

    /**
     * 发行总量
     */
    var issueAmount: BigDecimal = BigDecimal.ZERO,

    /**
     * 余量
     */
    var allowance: BigDecimal = BigDecimal.ZERO,

    /**
     * 发行单价
     */
    var issuePrice: BigDecimal = BigDecimal.ZERO,

    /**
     * 发行时间
     */
    var issueTime: Date? = null,

    /**
     * 总房产数量
     */
    var totalHouseNumber: BigDecimal = BigDecimal.ZERO,

    /**
     * 已出租房产数量
     */
    var rentOutNumber: BigDecimal = BigDecimal.ZERO,

    /**
     * 已出售房产数量
     */
    var sellNumber: BigDecimal = BigDecimal.ZERO,

    /**
     * 是否启用
     */
    var usingFlag: String = "",

    /**
     * 合约账户
     */
    var contractAccount: String = "",

    /**
     * 发行公司
     */
    var issueCompany: String = "",

    /**
     * token特点
     */
    var tokenIdentity: String = "",

    /**
     * 交易及收益规则
     */
    var txRule: String = "",

    /**
     * 资产详情
     */
    var assetDetails: String = "",

    /**
     * 公司介绍
     */
    var companyInfo: String = "",

    /**
     * 发行公司en
     */
    var issueCompanyEn: String = "",

    /**
     * token特点en
     */
    var tokenIdentityEn: String = "",

    /**
     * 交易及收益规则en
     */
    var txRuleEn: String = "",

    /**
     * 资产详情en
     */
    var assetDetailsEn: String = "",

    /**
     * 公司介绍en
     */
    var companyInfoEn: String = "",

    /**
     * 资产简称
     */
    var assetShort:String = "",

    /**
     * 资产简称en
     */
    var assetShortEn:String = ""
) : Base(), IVerify {
            var issueTimeBegin: Date? = null
            var issueTimeEnd: Date? = null

    override fun verify() {
        this.apply {
            "token名称 不能为空" using (this.tokenName.isNotEmpty())
            "token简称 不能为空" using (this.tokenShortName.isNotEmpty())
            "图片地址 不能为空" using (this.imgPath.isNotEmpty())
            "合约账户 不能为空" using (this.contractAccount.isNotEmpty())
            "预期收益 不能小于0" using (BigDecimal.ZERO.compareTo(this.expectedVenue)==-1)
            "发行总量 不能小于0" using (BigDecimal.ZERO.compareTo(this.issueAmount)==-1)
            "余量 不能小于0" using (BigDecimal.ZERO.compareTo(this.allowance)==-1)
            "发行单价 不能小于0" using (BigDecimal.ZERO.compareTo(this.issuePrice)==-1)
            "总房产数量 不能小于0" using (BigDecimal.ZERO.compareTo(this.totalHouseNumber)==-1)
            "已出租房产数量 不能小于0" using (BigDecimal.ZERO.compareTo(this.rentOutNumber)==-1)
            "已出售房产数量 不能小于0" using (BigDecimal.ZERO.compareTo(this.sellNumber)==-1)

        }
    }
}


