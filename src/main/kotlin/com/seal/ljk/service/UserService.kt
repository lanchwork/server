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
                val roleMenuList=RoleMenuList()
                roleMenuList.roleId = userDao.selectRoleTypeByUserId(user)

                /*var menuTypeSet= mutableSetOf<String>()
                var dataMap = hashMapOf<String,List<Menu>>()
                menuList.forEach{
                    menuTypeSet.add(it.menuType)
                }
                for (item in menuTypeSet) {
                    var resultList = arrayListOf<Menu>()
                    menuList.forEach() {
                        if(item.equals(it.menuType)){
                            resultList.add(it)
                        }
                    }
                    dataMap.put(item,resultList)
                }
                roleMenuList.map = dataMap*/

                var menuTypeSet= mutableSetOf<String>()
                var dataMap = hashMapOf<String,List<Menu>>()
                menuList.forEach{
                    menuTypeSet.add(it.pcode)
                }

                map.put("menu",roleMenuList)
                return map
            }
        }
        return null
    }
}
fun main(args: Array<String>) {
    var menuSet= mutableSetOf<String>()
    menuSet.add("123")
    menuSet.add("123")
    print(menuSet.toString())
}