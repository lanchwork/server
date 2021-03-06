package com.seal.ljk.model

import java.util.Date
import com.seal.ljk.model.Base
import com.seal.ljk.common.using
import com.seal.ljk.base.PrimaryKey
import java.math.BigDecimal

/**
 * <p>
 * 项目管理数据类
 * </p>
 * @author kangxj
 * @since 2019-01-02
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
        var expectedVenue: BigDecimal? = null,

        /**
         * 发行总量
         */
        var issueAmount: BigDecimal? = null,

        /**
         * 余量
         */
        var allowance: BigDecimal? = null,

        /**
         * 发行单价
         */
        var issuePrice: BigDecimal? = null,

        /**
         * 发行时间
         */
        var issueTime: Date? = null,

        /**
         * 总房产数量
         */
        var totalHouseNumber: BigDecimal? = null,

        /**
         * 已出租房产数量
         */
        var rentOutNumber: BigDecimal? = null,

        /**
         * 已出售房产数量
         */
        var sellNumber: BigDecimal? = null,

        /**
         * 是否启用
         */
        var usingFlag: String = "",

        /**
         * 钱包账户
         */
        var account: String = "",

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
        var assetShort: String = "",

        /**
         * 资产简称en
         */
        var assetShortEn: String = "",

        /**
         * token编号
         */
        var tokenNo: String = "",

        /**
         * 一句话收益说明
         */
        var incomeStatement: String = "",

        /**
         * 一句话收益说明en
         */
        var incomeStatementEn: String = "",

        /**
         * 汇率
         */
        var exchangeRate: BigDecimal? = null
) : Base(), IVerify {
    var issueTimeBegin: Date? = null
    var issueTimeEnd: Date? = null

    override fun verify() {
        "token编号不能为空" using (tokenNo.isNotEmpty())
        "token名称不能为空" using (tokenName.isNotEmpty())
        "token简称不能为空" using (tokenShortName.isNotEmpty())
        "图片地址不能为空" using (imgPath.isNotEmpty())

        "预期收益不能为空" using (expectedVenue != null)
        "总房产数量不能为空" using (totalHouseNumber != null)
        "已出租房产数量不能为空" using (rentOutNumber != null)
        "已出售房产数量不能为空" using (sellNumber != null)

        "汇率不能为空" using (exchangeRate != null)
        "钱包账户不能为空" using (account.isNotEmpty())
    }
}


