package com.seal.ljk.service

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTDecodeException
import com.seal.ljk.base.AuthException
import com.seal.ljk.base.ParamException
import com.seal.ljk.dao.MenuDao
import com.seal.ljk.dao.UserDao
import com.seal.ljk.model.Menu
import com.seal.ljk.model.User
import com.seal.ljk.query.QUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {
    

    @Autowired
    lateinit var userDao: UserDao

    @Autowired
    lateinit var menuDao: MenuDao

    fun createUser(user: User) {

        user.id = user.channelMark + user.username
        return userDao.createUser(user)
    }

    fun deleteUserById(userId: String) {
        return userDao.deleteUserById(userId)
    }

    fun updateUser(user: User) {
        return userDao.updateUser(user)
    }

    fun updatePasswordById(userId: String, password: String) {
        return userDao.updatePasswordById(userId, password)
    }

    fun getUserById(userId: String): User {
        return userDao.getUserById(userId)
    }


    fun queryUser(qUser: QUser): List<User> {
        return userDao.queryUser(qUser)
    }

    /**
     * 登入功能,登入后列出权限菜单
     * lanch
     */
    fun login(user: User): Map<String, Any>? {
        val data: User = userDao.selectUserByUsername(user)
        val map = hashMapOf<String, Any>()
        var dataMap= hashMapOf<String, Any>()
        if (data != null) {
            if (data.password.equals(user.password)) {
                map.put("user", data)
                dataMap= getMenuListByUser(data) as HashMap<String, Any>
            }
            map.put("menu", dataMap)
            return map
        }
        return null
    }

    /**
     * 根据用户id列出权限菜单
     * @param user 传入一个有用户Id的用户对象
     * @return 二次封装的菜单Map集合
     * lanch
     */
    fun getMenuListByUser(user: User): Map<String, Any> {
        val menuList = menuDao.selectMenuListByUserId(user)
        var dataMap = hashMapOf<String, Any>()
        dataMap.put("roleId", userDao.selectRoleTypeByUserId(user))
        var dataList = arrayListOf<Menu>()
        menuList.forEach {
            if ("0".equals(it.pcode)) {
                dataList.add(it)
            }
        }
        for (item in dataList) {
            var list= arrayListOf<Map<String,Any>>()
            menuList.forEach {
                var resultMap = HashMap<String, Any>()
                if (item.code.equals(it.pcode)) {
                    resultMap.put("menuId", it.id)
                    resultMap.put("menuName", it.menuName)
                    resultMap.put("pcode", it.pcode)
                    resultMap.put("code", it.code)
                    resultMap.put("sort",it.sort)
                    list.add(resultMap)
                }
            }
            dataMap.put(item.menuName, list)
        }
        return dataMap
    }
    
    fun getUserToken(user: User): String {
        return JWT.create().withAudience(user.id)
            .sign(Algorithm.HMAC256(user.password))
    }
    
    fun verifyUser(token: String?): User {
        if (token == null) {
            throw  ParamException()
        }
        // 获取 token 中的 user id
        val userId: String
        try {
            userId = JWT.decode(token).audience[0]
        } catch (j: JWTDecodeException) {
            throw  AuthException()
        }
        
        val user = getUserById(userId)
        // 验证 token
        val jwtVerifier = JWT.require(Algorithm.HMAC256(user.password)).build()
        
        try {
            jwtVerifier.verify(token)
        } catch (e: Exception) {
            throw  AuthException()
        }
        return user
        
    }
}
