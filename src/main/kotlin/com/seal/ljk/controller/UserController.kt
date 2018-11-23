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

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    lateinit var userService: UserService

    @RequestMapping("/add")
    fun create(@RequestBody user: User): ResVal{
        try {
            userService.create(user)
        } catch (e: Exception){
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    @GetMapping("/delete")
    fun deleteUserById(@RequestParam userId: String): ResVal {
        try {
            userService.deleteUserById(userId)
        } catch (e: Exception) {
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    @RequestMapping("/update")
    fun update(@RequestBody user: User): ResVal {
        try {
            userService.update(user)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResVal(1, "Data Access Error!")
        }
        return ResVal(0, "success")
    }

    @RequestMapping("/query")
    fun query(@RequestBody qUser: QUser): ResVal{
        val resultList: List<User>
        try {
            resultList = userService.query(qUser)
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