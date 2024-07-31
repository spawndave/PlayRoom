package com.academy.model.dao.impl;

import com.academy.model.dao.ProductDao;
import com.academy.model.entity.Product;
public class ProductDaoImpl extends DefaultDaoIml<Product> implements ProductDao {

    public ProductDaoImpl() {
        super(Product.class);
    }
}
