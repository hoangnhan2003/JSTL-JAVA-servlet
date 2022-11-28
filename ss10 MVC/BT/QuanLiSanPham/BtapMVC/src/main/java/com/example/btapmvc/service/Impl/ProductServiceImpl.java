package com.example.btapmvc.service.Impl;

import com.example.btapmvc.model.Product;
import com.example.btapmvc.repository.IProductRepository;
import com.example.btapmvc.repository.ipml.ProductRepositoryImpl;
import com.example.btapmvc.service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    private IProductRepository bookRepository = new ProductRepositoryImpl();

    public ProductServiceImpl() {
        bookRepository.saveOfUpdate(new Product("1","samsungA12",14000,"good","Korean"));
        bookRepository.saveOfUpdate(new Product("2","samsungA12",14000,"good","Korean"));
        bookRepository.saveOfUpdate(new Product("3","samsungA12",14000,"good","Korean"));
    }

    @Override
    public void saveOrUpdate(Product product) {

        this.bookRepository.saveOfUpdate(product);
    }

    @Override
    public void deleteById(String id) {

        this.bookRepository.deleteByID(id);
    }

    @Override
    public Product findById(String id) {

        return this.bookRepository.findByID(id);
    }

    @Override
    public List<Product> findAll() {

        return this.bookRepository.findAll();
    }
}
