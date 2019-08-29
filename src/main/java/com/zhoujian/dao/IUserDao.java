package com.zhoujian.dao;

import com.zhoujian.domain.Role;
import com.zhoujian.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.userdetails.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Mapper
public interface IUserDao {
    @Select("select * from users")
    List<UserInfo> findAll();
    @Select("select * from users where username=#{username}")
    UserInfo findByUsername(String username);
    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "email",property = "email"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles",many = @Many(select =
            "com.zhoujian.dao.IRoleDao.findByUserId"))
    })
    UserInfo findById(String id);
    //插入
    @Insert("insert into users (id,username,email,password,phoneNum,status)values(#{id},#{username},#{email},#{password},#{phoneNum},#{status})")
    Boolean saveUser(UserInfo user);
    //查询拥有的其他权限
    @Select("select * from role where id not in (select roleId from users_role where userId = #{id})")
    List<Role> findOtherRoles(String id);
    @Insert("insert into users_role(userId,roleId)values(#{userId},#{roleId})")
    void aaddRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
