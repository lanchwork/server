package com.seal.ljk

import com.seal.ljk.common.setSessionUser
import com.seal.ljk.model.SysPartner
import com.seal.ljk.model.SysUser
import com.seal.ljk.service.ISysPartnerService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.util.function.Consumer


/**
 * Created by chenjh on 2018/12/24.
 */
@RunWith(SpringRunner::class)
@SpringBootTest
class MapperTest {

    @Autowired
    lateinit var sysPartnerService: ISysPartnerService

    @Test
    fun testSelect() {
        var user = SysUser(id = "12345678",username = "admin",channelMark = "seal",name = "admin")
        setSessionUser(user)

        sysPartnerService.insertSysPartner(SysPartner(partnerName = "partnerName3", userNo = "userNo", channelMark = "mini"))

        println("----- selectAll method test ------")
        val userList = sysPartnerService.getAllSysPartner(SysPartner(channelMark = "mini"))
        userList.forEach(Consumer<SysPartner> { System.out.println() })
    }

}
