package com.example.btapmvc.service;

import com.example.btapmvc.model.Product;

import java.util.List;

public interface IProductService {
    void saveOrUpdate(Product product);
    void deleteById(String id);
    Product findById(String id);
    List<Product> findAll();
}
