package com.example.demo.repository.impl;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.ICategoryRepo;
import com.example.demo.repository.IProductRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepo implements IProductRepo {
    public static final String SELECT_ALL_PRODUCT = "SELECT * FROM product";
    public static final String INSERT_PRODUCT = "INSERT INTO product (`name_product`, `price`, `quantity`, `color`, `categoryId`) VALUES (?, ?, ?, ?, ?); ";
    public static final String UPDATE_PRODUCT = "UPDATE product SET `price` = ?, `quantity` = ?, `color` = ? WHERE (`name_product` = ?);";
    public static final String DELETE_PRODUCT = "DELETE FROM product WHERE name_product = ?";
    public static final String SELECT_PRODUCT_BY_NAME = "SELECT * FROM product WHERE name_product LIKE ?;";
    BaseRepository baseRepository = new BaseRepository();
    CategoryRepo categoryRepo = new CategoryRepo();
    @Override
    public void addProduct(Product newProduct) {
        Connection connection = this.baseRepository.getConnectionJAVAtoDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);
            preparedStatement.setString(1,newProduct.getNameProduct());
            preparedStatement.setFloat(2,newProduct.getPrice());
            preparedStatement.setInt(3,newProduct.getQuantity());
            preparedStatement.setString(4,newProduct.getColor());
            preparedStatement.setInt(5,newProduct.getCategory().getCategoryId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void Update(Product product) {
        Connection connection = this.baseRepository.getConnectionJAVAtoDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);
            preparedStatement.setFloat(1,product.getPrice());
            preparedStatement.setInt(2,product.getQuantity());
            preparedStatement.setString(3,product.getColor());
            preparedStatement.setString(4,product.getNameProduct());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteByNameProduct(String nameProduct) {
        Connection connection = this.baseRepository.getConnectionJAVAtoDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setString(1,nameProduct);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Product findByProductName(String nameProduct) {

        Connection connection = this.baseRepository.getConnectionJAVAtoDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_NAME);
            preparedStatement.setString(1,"%"+nameProduct+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product;
            while (resultSet.next()){
                String nameProductX = resultSet.getString("name_product");
                float price = resultSet.getFloat("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                int categoryID = resultSet.getInt("categoryID");
                Category category = categoryRepo.findCategoryByID(categoryID);
                product = new Product(nameProductX,price,quantity,color,category);
                return product;


            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  null;

    }

    @Override
    public List<Product> findAllProductName(String productName) {
        List<Product> productList = new ArrayList<>();
        Connection connection = this.baseRepository.getConnectionJAVAtoDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_NAME);
            preparedStatement.setString(1,"%"+productName+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product;
            while (resultSet.next()){
                String nameProductX = resultSet.getString("name_product");
                float price = resultSet.getFloat("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                int categoryID = resultSet.getInt("categoryID");
                Category category = categoryRepo.findCategoryByID(categoryID);
                product = new Product(nameProductX,price,quantity,color,category);

                productList.add(product);

            }
            return productList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        Connection connection = baseRepository.getConnectionJAVAtoDB();
        ICategoryRepo categoryRepo = new CategoryRepo();
        Product product;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String nameProduct = resultSet.getString("name_product");
                float price = resultSet.getFloat("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                int categoryID = resultSet.getInt("categoryID");
                Category category = categoryRepo.findCategoryByID(categoryID);
                product = new Product(nameProduct,price,quantity,color,category);
                productList.add(product);
            }
            return productList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
