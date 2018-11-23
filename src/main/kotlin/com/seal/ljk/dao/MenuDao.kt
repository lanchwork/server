package com.seal.ljk.dao

import com.seal.ljk.model.Menu
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

}















