package com.example.demo.repository;

import com.example.demo.model.Category;

import java.util.List;

public interface ICategoryRepo {
    List<Category> getAll();
    Category findCategoryByID(int categoryID);
}
