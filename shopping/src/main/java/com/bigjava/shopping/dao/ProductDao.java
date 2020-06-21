package com.bigjava.shopping.dao;

import com.bigjava.shopping.entity.Product;

import java.util.List;

public interface ProductDao {

    /**
     * 查询商品列表
     * @return
     */
    public List<Product> selectAll();

}
