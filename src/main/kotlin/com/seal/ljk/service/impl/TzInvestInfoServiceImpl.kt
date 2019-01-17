package com.seal.ljk.service.impl

import com.github.pagehelper.Page
import com.seal.ljk.base.IdNotFoundException
import com.seal.ljk.base.loggerFor
import com.seal.ljk.common.MessageDigestUtil
import com.seal.ljk.common.PushUtil
import com.seal.ljk.dao.TzInvestInfoDao
import com.seal.ljk.model.TzInvestInfo
import com.seal.ljk.model.TzMessageInfo
import com.seal.ljk.service.ITzInvestInfoService
import com.seal.ljk.service.ITzInvestItemService
import com.seal.ljk.service.ITzMessageInfoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal

/**
 * <p>
 * 投资信息 服务实现类
 * </p>
 *
 * @author lanch
 * @since 2018-12-28
 */
@Service
class TzInvestInfoServiceImpl : ITzInvestInfoService {

    val log = loggerFor(this.javaClass)

    @Autowired
    lateinit var tzInvestInfoDao: TzInvestInfoDao

    @Autowired
    lateinit var tzMessageInfoService: ITzMessageInfoService

    @Autowired
    lateinit var tzInvestItemService: ITzInvestItemService

    @Autowired
    lateinit var pushUtil: PushUtil

    override fun getTzInvestInfo(id: String): TzInvestInfo {
        return tzInvestInfoDao.get(id) ?: throw IdNotFoundException()
    }

    override fun getAllTzInvestInfo(tzInvestInfo: TzInvestInfo): List<TzInvestInfo> {
        return tzInvestInfoDao.getAll(tzInvestInfo)
    }

    override fun getAllTzInvestInfoByPage(tzInvestInfo: TzInvestInfo): Page<TzInvestInfo> {
        return tzInvestInfoDao.getAllByPage(tzInvestInfo)
    }

    override fun insertTzInvestInfo(tzInvestInfo: TzInvestInfo) {
        tzInvestInfoDao.insert(tzInvestInfo)
        checkSend(tzInvestInfo)
    }

    override fun updateTzInvestInfo(tzInvestInfo: TzInvestInfo) {
        getTzInvestInfo(tzInvestInfo.id).let {
            val successStatus = arrayOf('2', '5', '8')
            if (!successStatus.contains(it.status) && successStatus.contains(tzInvestInfo.status)) {
                it.status = tzInvestInfo.status
                checkSend(it)
            }
        }

        tzInvestInfoDao.update(tzInvestInfo)
    }


    override fun deleteTzInvestInfo(id: String) {}

    fun checkSend(info: TzInvestInfo) {
        val type = info.type
        val status = info.status
        if ('1' == type && '2' == status) {
            sendInvestPush(info)
        } else if ('2' == type && '5' == status) {
            sendInvestPush(info)
        } else if ('3' == type && '8' == status) {
            sendInvestPush(info)
        }
    }


    fun sendInvestPush(info: TzInvestInfo) {
        if (info.tokenName.isEmpty()) {
            val item = tzInvestItemService.getTzInvestItem(info.itemId)
            info.tokenName = item.tokenName
        }

        val isEn = info.lang.contains("en")
        val mobile = info.areaCode + info.mobile
        val alias = MessageDigestUtil
                .md5(if (info.account.isEmpty()) mobile else info.account)

        val title = pushTitle(info.type, info.tokenName, isEn)
        val content = pushContent(info.mobile, info.account, info.type, info.tokenName, info.buyNumber, isEn)


        val msg = TzMessageInfo(type = "1", mobile = mobile, account = info.account, itemId = info.itemId, title = title, content = content)
        tzMessageInfoService.insertTzMessageInfo(msg)


        val extras = mapOf(
                "type" to "1",
                "msg_id" to msg.id
        )

        pushUtil.sendPush(alias, title, content, extras)

    }


    public fun pushContent(mobile: String, account: String, type: Char?, tokenName: String, buyNumber: BigDecimal?, en: Boolean): String {
        val isMob = account.isEmpty()
        val last4 = (if (isMob) mobile else account).let {
            it.substring(it.length - 4)
        }
        val accType = if (en)
            if (isMob) "mobile number" else "account Number"
        else
            if (isMob) "手机尾号" else "Account账户"

        val optName = when (type) {
            '1' -> if (en) "purchased" else "买入"
            '2' -> if (en) "sold" else "卖出"
            '3' -> if (en) "bought back" else "回购"
            else -> if (en) "operate" else "操作"
        }
        return if (en)
            "Your $accType $last4 have $optName ${buyNumber?.toInt()} $tokenName, if you have any issues, please contact customer service."
        else
            "您$accType${last4}已$optName${buyNumber?.toInt()}个$tokenName，若有异议请联系客服。"
    }

    public fun pushTitle(type: Char?, tokenName: String, isEn: Boolean): String {
        val suc = if (isEn) "Completed" else "成功"
        val optName = when (type) {
            '1' -> if (isEn) "Purchase" else "买入"
            '2' -> if (isEn) "Sell" else "卖出"
            '3' -> if (isEn) "Buyback" else "回购"
            else -> if (isEn) "Operate" else "操作"
        }
        return "$optName $tokenName $suc"
    }
}
