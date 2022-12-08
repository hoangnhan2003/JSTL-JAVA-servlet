package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.repository.impl.CategoryRepo;
import com.example.demo.service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {
    CategoryRepo categoryRepo = new CategoryRepo();
    @Override
    public Category findById(int id) {
        return this.categoryRepo.findCategoryByID(id);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void addCategory(Category category) {

    }

    @Override
    public List<Category> getAll() {
        return this.categoryRepo.getAll();
    }
}
