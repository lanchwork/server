package com.seal.ljk.base

import com.seal.ljk.common.SysDictUtil
import com.seal.ljk.model.SysDictType
import com.seal.ljk.model.SysPartner
import com.seal.ljk.service.ISysDictTypeService
import com.seal.ljk.service.ISysPartnerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component
import javax.annotation.Resource


/**
 * @program: si-server
 *
 * @description: 项目启动事件监听类
 *
 * @author: tingyx
 *
 * @create: 2019-01-03 16:58
 **/
@Component
class ApplicationStartedEventListener : ApplicationListener<ApplicationStartedEvent> {

    var log = loggerFor(this.javaClass)

    @Autowired
    lateinit var sysDictTypeService: ISysDictTypeService
    @Autowired
    lateinit var sysPartnerService: ISysPartnerService

    override fun onApplicationEvent(event: ApplicationStartedEvent) {
        log.debug("application started .....")
        //取出所有字典类型及其数据项
        val sysDictTypes = sysDictTypeService.getAllSysDict()
        val sysDictTypesSeq = sysDictTypes.asSequence()
        val dictCodeSet = mutableSetOf<String>()
        //将字典类型的code放入set中
        sysDictTypesSeq.forEach {
            it["code"]?.let { it1 -> dictCodeSet.add(it1) }
        }
        dictCodeSet.forEach {
            //先过滤出code相同的所有数据项
            val items = sysDictTypesSeq.filter { item -> item["code"].equals(it) }.map { item ->
                //重新组织数据项内容
                mapOf(
                        "value" to item["value"].toString(),
                        "showVal" to item["show_val"].toString()
                )
            }.toList()
            SysDictUtil.sysDict[it] = items
        }

        val partners = sysPartnerService.getAllSysPartner(SysPartner())
        SysDictUtil.sysDict["partner"] = partners.map {
            mapOf(
                    "value" to it.channelMark,
                    "showVal" to it.partnerName
            )
        }




    }
}
