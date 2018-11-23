package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.User
import com.seal.ljk.query.QUser
import com.seal.ljk.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession

/**
 * 用户管理
 */
@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    lateinit var userService: UserService

    /**
     * 用户新增
     */
    @RequestMapping("/add")
    fun createUser(@RequestBody user: User): ResVal{
        try {
            userService.createUser(user)
        } catch (e: Exception){
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    /**
     * 用户删除
     */
    @GetMapping("/delete")
    fun deleteUserById(@RequestParam userId: String): ResVal {
        try {
            userService.deleteUserById(userId)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    /**
     * 用户更新
     */
    @RequestMapping("/update")
    fun updateUser(@RequestBody user: User): ResVal {
        try {
            userService.updateUser(user)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    /**
     * 获取用户
     */
    @GetMapping("/getById")
    fun getUserById(@RequestParam userId: String): ResVal {
        val result: User
        try {
            result = userService.getUserById(userId)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, result)
    }

    /**
     * 条件查询用户
     */
    @RequestMapping("/query")
    fun queryUser(@RequestBody qUser: QUser): ResVal{
        val resultList: List<User>
        try {
            resultList = userService.queryUser(qUser)
        } catch (e: Exception){
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, resultList)
    }


    /**
     *登入功能
     */
    @RequestMapping("/login")
    fun login(@RequestBody user:User,httpServletRequest: HttpServletRequest): ResVal{
        try {
            val session : HttpSession = httpServletRequest.getSession(true)
            val data:Map<String,Any>? = userService.login(user)
            if(data!=null){
                session.setAttribute("data",data.get("user"))
                return ResVal(0, data.get("menu"))
            }
        } catch (e: Exception){
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(1, "账户或密码错误")
    }
}