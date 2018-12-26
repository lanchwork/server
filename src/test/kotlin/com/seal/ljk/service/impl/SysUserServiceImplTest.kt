package com.seal.ljk.service.impl

import com.seal.ljk.service.ISysUserService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner


/**
 * Created by chenjh on 2018/12/25.
 */
@RunWith(SpringRunner::class)
@SpringBootTest
class SysUserServiceImplTest {
    @Autowired
    lateinit var sysUserService: ISysUserService


    @Test
    fun getUserToken() {
        val user = sysUserService.getSysUser("2776cd3a081011e9bd39fa163e168207")!!
        val userToken = sysUserService.getUserToken(user)
        println(userToken)
        sysUserService.verifyUser(userToken)
    }

}
