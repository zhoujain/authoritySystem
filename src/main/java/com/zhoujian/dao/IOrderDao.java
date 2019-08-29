package com.zhoujian.dao;

import com.zhoujian.domain.Orders;
import com.zhoujian.domain.Product;
import org.apache.ibatis.annotations.*;
import org.omg.IOP.Codec;

import java.util.List;
@Mapper
public interface IOrderDao {
    //查询所有
    @Select("select * from orders")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property ="payType" ),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType = Product.class,one =@One(select=
            "com.zhoujian.dao.IProductDao.findById"))

    })
    List<Orders> findAll() throws Exception;
    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property ="payType" ),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType = Product.class,one =@One(select=
                    "com.zhoujian.dao.IProductDao.findById")),
            @Result(column = "id",property = "travellers",many =@Many(select=
                    "com.zhoujian.dao.ITravellerDao.findByOrdersId")),
            @Result(column = "memberId",property = "member",one =@One(select=
                    "com.zhoujian.dao.IMemberDao.findById"))

    })
    Orders findById(String id)throws Exception;
}
