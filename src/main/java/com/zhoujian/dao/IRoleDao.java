package com.zhoujian.dao;

import com.zhoujian.domain.Permission;
import com.zhoujian.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IRoleDao {
    @Select("select * from role where id = #{id}")
    Role findById(String id)throws Exception;

    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results(value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType =java.util.List.class, many =@Many(select = "com.zhoujian.dao.IPermissionDao.findByRoleId")),
    })
    List<Role> findByUserId(String userId)throws Exception;

    @Select("select * from role")
    List<Role> findAll();
    @Insert("insert into role (id,roleName,roleDesc)values(#{id},#{roleName},#{roleDesc})")
    void save(Role role);
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{id})")
    List<Permission> findOtherPermission(String id);
    @Insert("insert into role_permission(roleId,permissionId)values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId,@Param("permissionId") String permissionId);
}
