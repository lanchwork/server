package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.User
import com.seal.ljk.query.QUser
import com.seal.ljk.service.UserService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
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
@Api(description = "用户管理功能相关接口")
class UserController {

    @Autowired
    lateinit var userService: UserService

    /**
     * 用户新增
     */
    @PostMapping("/add")
    @ApiOperation(value = "用户新增")
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
    @PostMapping("/delete")
    @ApiOperation(value = "用户删除")
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
    @PostMapping("/update")
    @ApiOperation(value = "用户更新")
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
     * 用户修改密码
     */
    @PostMapping("/updatePassword")
    @ApiOperation(value = "用户修改密码")
    fun updatePasswordById(@RequestParam userId: String,@RequestParam password: String): ResVal {
        try {
            userService.updatePasswordById(userId,password)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    /**
     * 获取用户
     */
    @PostMapping("/getById")
    @ApiOperation(value = "获取用户")
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
    @PostMapping("/query")
    @ApiOperation(value = "条件查询用户")
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
    @PostMapping("/login")
    @ApiOperation(value = "登入功能")
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