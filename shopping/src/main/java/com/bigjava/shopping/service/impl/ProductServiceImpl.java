package com.bigjava.shopping.service.impl;

import com.bigjava.shopping.dao.ProductDao;
import com.bigjava.shopping.entity.Product;
import com.bigjava.shopping.facotry.ObjectFactory;
import com.bigjava.shopping.service.ProductService;
import com.itany.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = (ProductDao) ObjectFactory.getObject("productDao");

    @Override
    public List<Product> findAll() {
        return productDao.selectAll();
    }

}
