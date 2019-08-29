package com.zhoujian.dao;

import com.zhoujian.domain.Permission;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface IPermissionDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    List<Permission> findByRoleId(String id);
    @Select("select * from permission")
    List<Permission> findAll();

    @Insert("insert into permission (id,permissionName,url)values(#{id},#{permissionName},#{url})")
    void save(Permission permission);
}
