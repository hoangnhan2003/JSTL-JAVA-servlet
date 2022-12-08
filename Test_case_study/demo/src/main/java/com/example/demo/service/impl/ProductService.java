package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.repository.ICategoryRepo;
import com.example.demo.repository.IProductRepo;
import com.example.demo.repository.impl.CategoryRepo;
import com.example.demo.repository.impl.ProductRepo;
import com.example.demo.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    ICategoryRepo categoryRepo = new CategoryRepo();
    IProductRepo productRepo = new ProductRepo();

    @Override
    public void insertProduct(Product newProduct) {
        productRepo.addProduct(newProduct);
    }

    @Override
    public Product findByProductName(String productName) {
        return productRepo.findByProductName(productName);
    }

    @Override
    public List<Product> findAllProductName(String productName) {
        return this.productRepo.findAllProductName(productName);
    }

    @Override
    public void deleteByProductName(String productName) {
        productRepo.deleteByNameProduct(productName);
    }

    @Override
    public void updateProduct(Product product) {
        productRepo.Update(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepo.getAll();
    }
}
