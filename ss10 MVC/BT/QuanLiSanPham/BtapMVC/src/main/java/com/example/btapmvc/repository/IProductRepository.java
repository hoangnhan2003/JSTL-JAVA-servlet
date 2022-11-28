package com.example.btapmvc.repository;

import com.example.btapmvc.model.Product;

import java.util.List;

public interface IProductRepository {
    void saveOfUpdate(Product product);
    void deleteByID(String id);
    Product findByID(String id);
    List<Product> findAll();
}
