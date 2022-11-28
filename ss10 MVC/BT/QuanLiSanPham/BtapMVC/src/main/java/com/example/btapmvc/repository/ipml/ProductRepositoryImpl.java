package com.example.btapmvc.repository.ipml;

import com.example.btapmvc.model.Product;
import com.example.btapmvc.repository.IProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements IProductRepository {
    private Map<String, Product> productMap = new HashMap<>();


    public ProductRepositoryImpl() {

    }

    @Override
    public void saveOfUpdate(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public void deleteByID(String id) {
        productMap.remove(productMap.get(id));

    }

    @Override
    public Product findByID(String id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }
}
