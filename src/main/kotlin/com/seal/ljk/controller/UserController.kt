package com.seal.ljk.controller

import com.seal.ljk.dao.UserDao
import org.apache.ibatis.annotations.Param
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class UserController {

    @Autowired
    lateinit var userDao: UserDao

    @GetMapping("/all")
    fun getAllUser() : Any {
        val users = userDao.getAllUser()
        return users
    }

    @PostMapping("/user")
    fun createUser(@Param("id") id : Int, @Param("name")name : String) : Any {
        userDao.createUser(id, name)
        return getAllUser()
    }

    @DeleteMapping("user")
    fun deleteUserById(@Param("id") id : Int) : Any {
        userDao.deleteUserById(id)
        return getAllUser()
    }

    @PutMapping("/user")
    fun updateUserById(@Param("id") id : Int, @Param("name")name : String) : Any {
        userDao.updateUserById(id, name)
        return getAllUser()
    }

    @GetMapping("/user")
    fun getUserById(id : Int) : Any {
        val user = userDao.getUserById(id)
        return user
    }

    @GetMapping("/list")
    fun getUserList(@Param("currentPage") currentPage : Int, @Param("pageSize") pageSize : Int) : Any {
        val currentPageNew = (currentPage - 1) * pageSize
        val users = userDao.getUserList(currentPageNew, pageSize)
        return users
    }

}