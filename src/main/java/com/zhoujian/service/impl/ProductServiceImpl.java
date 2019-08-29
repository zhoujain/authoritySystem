package com.zhoujian.service.impl;

import com.zhoujian.dao.IProductDao;
import com.zhoujian.domain.Product;
import com.zhoujian.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;
    @Override
    public List<Product> findAll() throws Exception {
       return productDao.findAll();
    }
    //产品添加
    @Override
    public void save(Product product) throws Exception {
        product.setId(UUID.randomUUID().toString());
        productDao.save(product);

    }
}
