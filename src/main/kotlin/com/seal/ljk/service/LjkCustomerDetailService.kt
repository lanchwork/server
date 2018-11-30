package com.seal.ljk.service

import com.seal.ljk.dao.LjkCustomerDetailDao
import com.seal.ljk.model.LjkCustomerDetail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


/**
 * @program: si-server
 *
 * @description: 链金控客户详细信息
 *
 * @author: tingyx
 *
 * @create: 2018-11-30 11:14
 **/
@Service
class LjkCustomerDetailService {

    @Autowired
    lateinit var ljkCustomerDetailDao: LjkCustomerDetailDao

    fun getCustomerDetailByKey(customerId: String): List<LjkCustomerDetail> {
        val customerDetailList = ljkCustomerDetailDao.getCustomerDetailByKey(customerId)
//        val list = mutableListOf<Map<String,String>>()
//        customerDetailList.forEach {
//            val map = mutableMapOf<String, String>(
//                    "客户编号" to it.customerId,
//                    "渠道标识" to it.channelMark,
//                    "证件类型" to it.certificateType,
//                    "证件号" to it.certificateNo,
//                    "性别" to it.sex,
//                    "出生日期" to it.birthday,
//                    "婚姻状况" to it.marriage,
//                    "家庭住址" to it.homeAddr,
//                    "手机号码" to it.mobileNo,
//                    "固定电话" to it.telNo,
//                    "不动产状况" to it.realEstate,
//                    "车辆状况" to it.vehicle,
//                    "Email" to it.email,
//                    "持卡情况" to it.cardStatus,
//                    "银行卡号" to it.bankCardNo,
//                    "开户行" to it.openingBank,
//                    "职业" to it.occupation,
//                    "工作年限" to it.workingYears,
//                    "学历" to it.education,
//                    "收入水平" to it.incomeLevel,
//                    "公司职位" to it.position,
//                    "公司名称" to it.companyName,
//                    "公司电话" to it.companyTel,
//                    "公司地址" to it.companyAddr,
//                    "发薪周期" to it.payrollCycle,
//                    "发薪日" to it.payday,
//                    "备注" to it.remark,
//                    "操作类型" to it.opType)
//            list.add(map)
//        }
        return customerDetailList
    }
}
