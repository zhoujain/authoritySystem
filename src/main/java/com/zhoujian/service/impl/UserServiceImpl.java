package com.zhoujian.service.impl;

import com.zhoujian.dao.IUserDao;
import com.zhoujian.domain.Role;
import com.zhoujian.domain.UserInfo;
import com.zhoujian.service.IUserService;
import com.zhoujian.utils.BCryptPasswordEncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    @Override
    public UserInfo findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public Boolean saveUser(UserInfo userInfo) {
        userInfo.setId(UUID.randomUUID().toString());
        //加密
       userInfo.setPassword(BCryptPasswordEncoderUtils.encodePassword(userInfo.getPassword()));
        return userDao.saveUser(userInfo);
    }

    @Override
    public List<Role> findOtherRole(String id)throws Exception {
        return userDao.findOtherRoles(id);
    }

    @Override
    public void addRoleToUser(String userid, String[] roles) {
        for(String roleId:roles){
            userDao.aaddRoleToUser(userid,roleId);
        }
    }
}
