package com.seal.ljk.dao

import com.seal.ljk.model.User
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface UserDao {

    @Select("select * from user")
    fun getAllUser(): List<User>

    @Select("select * from user where id = #{id}")
    fun getUserById(@Param("id") id : Int?): User

    @Insert("insert into user(id, name) values(#{id}, #{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    fun createUser(@Param("id") id : Int, @Param("name") name : String)

    @Delete("delete from user where id = #{id}")
    fun deleteUserById(@Param("id") id: Int)

    @Update("update user set name=#{name} where id=#{id}")
    fun updateUserById(@Param("id") id : Int, @Param("name") name : String)

    @Select("select * from user limit #{currentPage}, #{pageSize}")
    fun getUserList(@Param("currentPage") currentPage : Int, @Param("pageSize") pageSize : Int): List<User>

}
