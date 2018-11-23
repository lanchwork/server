package com.seal.ljk.dao

import com.seal.ljk.model.Menu
import com.seal.ljk.model.RoleMenu
import com.seal.ljk.model.RoleMenuList
import com.seal.ljk.model.User
import com.seal.ljk.provider.RoleMenuProvider
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface MenuDao {

    @Insert("insert into menu(menu_name)" +
            "values(#{menu.menuName})")
    fun createMenu(@Param("menu") menu : Menu)

    @Delete("delete from menu where id = #{menuId}")
    fun deleteMenuById(menuId: String)

    @Update("update menu set menu_name=#{menu.menuName} where id = #{menu.id}")
    fun updateMenu(@Param("menu") menu: Menu)

    @Select("select id,menu_name from menu limit #{currentPage}, #{pageSize}")
    fun getMenuList(@Param("currentPage")currentPage: Int, @Param("pageSize")pageSize: Int): List<Menu>

    @Select("SELECT m.id as id,m.menu_name as menu_name FROM user u JOIN role r ON u.role_type=r.id JOIN role_menu rm ON r.id=rm.role_id JOIN menu m ON  rm.menu_id=m.id WHERE u.id=#{user.id}")
    fun selectMenuListByUserId(@Param("user") user: User):List<Menu>

    @InsertProvider(type = RoleMenuProvider::class, method = "updateRoleMenu")
    fun updateRoleMenu(roleMenuList: RoleMenuList)

    @Select("select role_id,menu_id from role_menu where role_id = #{roleId}")
    fun queryRoleMenu(roleId: Int):List<RoleMenu>
}















