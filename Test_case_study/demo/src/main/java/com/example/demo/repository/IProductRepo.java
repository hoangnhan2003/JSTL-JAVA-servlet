package com.example.demo.repository;

import com.example.demo.model.Product;

import java.util.List;

public interface IProductRepo {
    void addProduct(Product newProduct);
    void Update(Product product);
    void deleteByNameProduct(String nameProduct);
    Product findByProductName(String nameProduct);
    List<Product> findAllProductName(String productName);
    List<Product> getAll();

}
