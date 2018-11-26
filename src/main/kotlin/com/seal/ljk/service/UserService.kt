package com.seal.ljk.service

import com.seal.ljk.dao.MenuDao
import com.seal.ljk.dao.UserDao
import com.seal.ljk.model.Menu
import com.seal.ljk.model.RoleMenuList
import com.seal.ljk.model.User
import com.seal.ljk.query.QUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var userDao: UserDao

    @Autowired
    lateinit var menuDao:MenuDao

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

    fun updatePasswordById(userId:String,password: String) {
        return userDao.updatePasswordById(userId,password)
    }

    fun getUserById(userId: String): User {
        return userDao.getUserById(userId)
    }


    fun queryUser(qUser: QUser): List<User> {
        return userDao.queryUser(qUser)
    }
    fun login(user:User):Map<String, Any>?{
        val data:User = userDao.selectUserByUsername(user)
        val map= hashMapOf<String,Any>()
        if(data!=null){
            if(data.password.equals(user.password)){
                map.put("user", data)
                val menuList=menuDao.selectMenuListByUserId(data)

                var dataMap = hashMapOf<String,Any>()
                dataMap.put("roleId",userDao.selectRoleTypeByUserId(data))
                var dataList = arrayListOf<Menu>()
                menuList.forEach{
                    if("0".equals(it.pcode)){
                        dataList.add(it)
                    }
                }
                for(item in dataList){
                    var resultMap = HashMap<String,Any>()
                    menuList.forEach{
                        if(item.code.equals(it.pcode)){
                            resultMap.put("menuId",it.id)
                            resultMap.put("menuName",it.menuName)
                            resultMap.put("pcode",it.pcode)
                            resultMap.put("code",it.code)
                        }
                    }
                    dataMap.put(item.menuName,resultMap)
                }

                map.put("menu",dataMap)
                return map
            }
        }
        return null
    }
}