package com.bigjava.shopping.service.proxy;

import com.bigjava.shopping.entity.Product;
import com.bigjava.shopping.exception.DataAccessException;
import com.bigjava.shopping.exception.ServiceException;
import com.bigjava.shopping.facotry.ObjectFactory;
import com.bigjava.shopping.service.ProductService;
import com.itany.jdbc.transaction.TransactionManager;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceProxy implements ProductService {

    private TransactionManager tx = (TransactionManager) ObjectFactory.getObject("tx");
    private ProductService productService = (ProductService) ObjectFactory.getObject("productService");

    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        try {
            tx.beginTransaction();
            list = productService.findAll();
            tx.commit();
        } catch (DataAccessException e) {
            tx.rollback();
            throw new ServiceException("服务异常", e);
        }
        return list;
    }

}
