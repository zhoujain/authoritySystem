package com.zhoujian.service.impl;

import com.zhoujian.dao.IPermissionDao;
import com.zhoujian.domain.Permission;
import com.zhoujian.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private IPermissionDao permissionDao;


    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        permission.setId(UUID.randomUUID().toString());
        permissionDao.save(permission);
    }
}
