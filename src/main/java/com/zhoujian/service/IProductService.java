package com.zhoujian.service;

import com.zhoujian.domain.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll()throws Exception;

    void save(Product product)throws Exception;
}
