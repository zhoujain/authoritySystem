package com.zhoujian.service.impl;

import com.zhoujian.dao.IRoleDao;
import com.zhoujian.domain.Permission;
import com.zhoujian.domain.Role;
import com.zhoujian.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private  IRoleDao roleDao;
    @Override
    public Role findById(String id) throws Exception {
        return roleDao.findById(id);
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        role.setId(UUID.randomUUID().toString());
        roleDao.save(role);
    }

    @Override
    public List<Permission> findOtherPermission(String id) throws Exception {
        return roleDao.findOtherPermission(id);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissions) {
        for(String permissionId:permissions){
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
