package com.seal.ljk.dao


import com.seal.ljk.model.Menu
import com.seal.ljk.model.User
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository


@Repository
interface MenuDao {
    @Select("SELECT m.id as id,m.menu_name as menu_name FROM user u JOIN role r ON u.role_type=r.id JOIN role_menu rm ON r.id=rm.role_id JOIN menu m ON  rm.menu_id=m.id WHERE u.id=#{user.id}")
fun selectMenuListByUserId(@Param("user") user: User):List<Menu>
}















