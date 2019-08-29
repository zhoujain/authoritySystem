package com.zhoujian.service;

import com.zhoujian.domain.Permission;

import java.util.List;

public interface IPermissionService {


    List<Permission> findAll();

    void save(Permission permission);
}
