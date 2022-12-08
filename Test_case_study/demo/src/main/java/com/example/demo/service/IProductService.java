package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface IProductService {
    void insertProduct(Product newProduct);
    Product findByProductName(String productName);
    List<Product> findAllProductName(String productName);
    void deleteByProductName(String productName);
    void updateProduct(Product product);
    List<Product> getAll();

}
