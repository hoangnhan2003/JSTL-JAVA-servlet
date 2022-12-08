package com.example.demo.service;

import com.example.demo.model.Category;

import java.util.List;

public interface ICategoryService {
    Category findById(int id);
    void deleteById(int id);
    void addCategory(Category category);
    List<Category> getAll();
}
