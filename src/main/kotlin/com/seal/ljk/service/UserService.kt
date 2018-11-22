package com.seal.ljk.service

import com.seal.ljk.dao.UserDao
import com.seal.ljk.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userDao: UserDao

    fun create(user: User){
        user.id=user.channelMark+user.username
        return userDao.create(user)
    }

}