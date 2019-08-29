package com.zhoujian.service;

import com.zhoujian.domain.Permission;
import com.zhoujian.domain.Role;

import java.util.List;

public interface IRoleService {

    Role findById(String id) throws Exception;

    List<Role> findAll();

    void save(Role role) throws Exception;

    List<Permission> findOtherPermission(String id) throws Exception;

    void addPermissionToRole(String roleId, String[] permissions);
}
