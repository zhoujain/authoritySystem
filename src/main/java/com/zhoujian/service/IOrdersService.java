package com.zhoujian.service;

import com.zhoujian.domain.Orders;

import java.util.List;

public interface IOrdersService {
    List<Orders> findAll() throws Exception;

    List<Orders> findAllByPage(int page,int pageSize)throws Exception;

    Orders findById(String id)throws  Exception;
}
