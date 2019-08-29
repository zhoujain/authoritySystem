package com.zhoujian.security;

import com.zhoujian.domain.Role;
import com.zhoujian.domain.UserInfo;
import com.zhoujian.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        //从数据库抽取user
        UserInfo user = userService.findByUsername(username);
        //判断用户是否存在
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        //添加权限
        List<Role> roles = userService.findById(user.getId()).getRoles();
        for(Role role:roles){
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        //返回UserDetails实现类
        return new User(user.getUsername(),user.getPassword(),authorities);
    }
}
