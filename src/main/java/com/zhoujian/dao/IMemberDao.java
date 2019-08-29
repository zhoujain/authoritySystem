package com.zhoujian.dao;

import com.zhoujian.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IMemberDao {
    @Select("select * from member where id=#{id}")
    Member findById(String id)throws Exception;
}
