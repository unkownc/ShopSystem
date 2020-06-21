package com.bigjava.shopping.dao.impl;

import com.bigjava.shopping.dao.ProductDao;
import com.bigjava.shopping.entity.Product;
import com.bigjava.shopping.facotry.ObjectFactory;
import com.bigjava.shopping.mapper.ProductMapper;
import com.itany.jdbc.core.JdbcTemplate;
import com.itany.jdbc.util.RowMapper;

import java.util.List;

public class ProductDaoImpl implements ProductDao {

   private JdbcTemplate<Product> jt = (JdbcTemplate<Product>) ObjectFactory.getObject("jt");
   RowMapper<Product> map = new ProductMapper();

    @Override
    public List<Product> selectAll() {
        String sql = new StringBuffer().append(" select ").append(" id,name,price").append(" from ").append(" t_product ").toString();
        return jt.query(sql,map);
    }
}
