package com.seal.ljk.dao

import com.seal.ljk.model.Role
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
interface RoleDao {

    @Insert("insert into role(role_name,role_description,create_date,create_user,update_date,update_user)" +
            "values(#{role.roleName},#{role.roleDescription},#{role.createDate},#{role.createUser},#{role.updateDate},#{role.updateUser})")
    fun createRole(@Param("role") role : Role)

    @Delete("delete from role where id = #{roleId}")
    fun deleteRoleById(roleId: String)

    @Update("update role set role_name=#{role.roleName},role_description=#{role.roleDescription},create_date=#{role.createDate},create_user=#{role.createUser},update_date=#{role.updateDate},update_user=#{role.updateUser} where id = #{role.id}")
    fun updateRole(@Param("role") role: Role)

    @Select("select id,role_name,role_description,create_date,create_user,update_date,update_user from role limit #{currentPage}, #{pageSize}")
    fun getRoleList(@Param("currentPage")currentPage: Int, @Param("pageSize")pageSize: Int): List<Role>


}















