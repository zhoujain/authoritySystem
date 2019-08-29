package com.zhoujian.service;

import com.zhoujian.domain.Role;
import com.zhoujian.domain.UserInfo;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface IUserService  {

    List<UserInfo> findAll();

    UserInfo findByUsername(String username);

    UserInfo findById(String id);

    Boolean saveUser(UserInfo userInfo);

    List<Role> findOtherRole(String id) throws Exception;

    void addRoleToUser(String userid, String[] roles);
}
