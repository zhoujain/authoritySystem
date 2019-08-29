package com.zhoujian.dao;

import com.zhoujian.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
@Mapper
public interface IProductDao {
    //根据id查询产品信息
    @Select("select * from product where id = #{id}")
    Product findById(String id)throws Exception;
    //查询所有产品信息
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    @Insert("insert into product(id,productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus)" +
            "values(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    //
}
