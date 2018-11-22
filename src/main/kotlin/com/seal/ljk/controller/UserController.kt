package com.seal.ljk.controller

import com.seal.ljk.common.ResVal
import com.seal.ljk.model.User
import com.seal.ljk.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception

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

}