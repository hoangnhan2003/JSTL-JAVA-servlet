package com.example.demo.repository.impl;

import com.example.demo.model.Category;
import com.example.demo.repository.ICategoryRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CategoryRepo implements ICategoryRepo {
    public static final String SELECT_ALL_CATEGORY = "SELECT * FROM category";
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Category> getAll() {
        List<Category> categoryList =new ArrayList<>();
        Connection connection = this.baseRepository.getConnectionJAVAtoDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            Category category;
            while (resultSet.next()){
                int categoryID = resultSet.getInt("categoryID");
                String categoryName = resultSet.getString("categoryName");
                category = new Category(categoryID,categoryName);
                categoryList.add(category);
            }
            return categoryList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Category findCategoryByID(int categoryID) {
        Connection connection = this.baseRepository.getConnectionJAVAtoDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM category where categoryID = ?");
            preparedStatement.setInt(1,categoryID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int categoryIDX = resultSet.getInt("categoryID");
                String categoryName = resultSet.getString("categoryName");
                return new Category(categoryIDX,categoryName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


}
