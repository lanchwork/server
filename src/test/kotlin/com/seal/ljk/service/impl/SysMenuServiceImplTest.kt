package com.seal.ljk.service.impl

import com.alibaba.fastjson.JSON
import com.seal.ljk.common.setSessionUser
import com.seal.ljk.model.SysMenu
import com.seal.ljk.model.SysUser
import com.seal.ljk.service.ISysMenuService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

/**
 * Created by chenjh on 2018/12/26.
 */
//@RunWith(SpringRunner::class)
//@SpringBootTest
class SysMenuServiceImplTest {

//    @Autowired
//    lateinit var sysMenuService: ISysMenuService

    @Test
    fun getAllSysMenuByUser() {
//        val user = SysUser(channelMark = "seal", userType = "1")
//        setSessionUser(user)
//
//        val menuList = sysMenuService.getAllSysMenuByPage(SysMenu())
//        println(JSON.toJSON(menuList))

    }

    @Test
    fun insertSysMenu() {
//        val menu0 = SysMenu(parentId = "0", menuName = "首页", sort = 0,type = 0)
//        insertSysChildMenu(menu0)
//        val menu1 = SysMenu(parentId = "0", menuName = "链上数据", sort = 1,type = 0)
//        insertSysChildMenu(menu1)
//        val menu2 = SysMenu(parentId = "0", menuName = "投资理财", sort = 2,type = 0)
//        insertSysChildMenu(menu2)
//        val menu3 = SysMenu(parentId = "0", menuName = "系统管理", sort = 3,type = 0)
//        insertSysChildMenu(menu3)
    }

    fun insertSysChildMenu(menu: SysMenu, num: Int = 2) {
//        sysMenuService.insertSysMenu(menu)
//        if (num == 0) {
//            return
//        }
//        for (i in 0..5) {
//            val child = SysMenu(parentId = menu.id, menuName = menu.menuName + "-$i", sort = i,type = num)
//            insertSysChildMenu(child, num - 1)
//        }
    }
}
