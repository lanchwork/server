package com.seal.ljk.model


/**
 * @program: si-server
 *
 * @description: 链金控客户详细信息
 *
 * @author: tingyx
 *
 * @create: 2018-11-30 11:06
 **/
data class LjkCustomerDetail (
    //客户详细信息
    var customerId: String = "",    //客户编号
    var channelMark: String = "",        //渠道标识
    var channelCustomerId: String = "",        //渠道客户编号
    var sealWallet:String = "",        //SEAL钱包
    var certificateType:String = "",        //证件类型
    var certificateNo:String = "",        //证件号
    var sex:String = "",        //性别
    var birthday:String = "",        //出生日期
    var marriage:String = "",        //婚姻状况
    var homeAddr:String = "",        //家庭住址
    var mobileNo:String = "",        //手机号码
    var telNo:String = "",        //固定电话
    var realEstate:String = "",        //不动产状况
    var vehicle:String = "",        //车辆状况
    var email:String = "",        //Email
    var cardStatus:String = "",        //持卡情况
    var bankCardNo:String = "",        //银行卡号
    var openingBank:String = "",        //开户行
    var occupation:String = "",        //职业
    var workingYears:String = "",        //工作年限
    var education:String = "",        //学历
    var incomeLevel:String = "",        //收入水平
    var position:String = "",        //公司职位
    var companyName:String = "",        //公司名称
    var companyTel:String = "",        //公司电话
    var companyAddr:String = "",        //公司地址
    var payrollCycle:String = "",        //发薪周期
    var payday:String = "",        //发薪日
    var remark: String = "",        //备注
    var opType: String = "",        //操作类型
    var updateTime: String = "",    //上链时间

    var remark1: String = "",
    var remark2: String = "",
    var remark3: String = "",
    var remark4: String = "",
    var remark5: String = ""
)