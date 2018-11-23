package com.seal.ljk.service

import com.seal.ljk.dao.UserDao
import com.seal.ljk.model.User
import com.seal.ljk.query.QUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userDao: UserDao

    fun createUser(user: User){
        user.id=user.channelMark+user.username
        return userDao.createUser(user)
    }

    fun deleteUserById(userId: String) {
        return userDao.deleteUserById(userId)
    }

    fun updateUser(user: User) {
        return userDao.updateUser(user)
    }

    fun getUserById(userId: String): User {
        return userDao.getUserById(userId)
    }


    fun queryUser(qUser: QUser): List<User> {
        return userDao.queryUser(qUser)
    }
    fun login(user:User):User?{
        val data:User = userDao.selectUserByUsername(user)
        if(data!=null){
            if(data.password.equals(user.password)){
                return data
            }
        }
        return null
    }



}