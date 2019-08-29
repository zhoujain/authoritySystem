package com.zhoujian.service.impl;

import com.github.pagehelper.PageHelper;
import com.zhoujian.dao.IOrderDao;
import com.zhoujian.domain.Orders;
import com.zhoujian.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrderDao orderDao;
    @Override
    public List<Orders> findAll() throws Exception {
        //pageNum页码值 pageSize 每页条数
        PageHelper.startPage(1,5);
        return orderDao.findAll();
    }

    @Override
    public List<Orders> findAllByPage(int page, int pageSize) throws Exception {
       PageHelper.startPage(page,pageSize);
       return orderDao.findAll();
    }

    @Override
    public Orders findById(String id)throws Exception {
        return orderDao.findById(id);
    }


}
