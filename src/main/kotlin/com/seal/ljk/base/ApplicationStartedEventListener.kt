package com.seal.ljk.base

import com.seal.ljk.service.ISysDictTypeService
import com.seal.ljk.service.ISysPartnerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component


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
        sysDictTypeService.refreshCache()
    }
}
