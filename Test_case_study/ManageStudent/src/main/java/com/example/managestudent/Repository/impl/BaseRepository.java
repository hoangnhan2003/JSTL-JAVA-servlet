package com.example.managestudent.Repository.impl;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private Connection connection;
    private String userName = "root";
    private String password ="";
    private String jdbcURL = "jdbc:mysql://localhost:3306/managestudent?useSSL=false";
    public Connection getConnectionJAVAToDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcURL,userName,password);
            return connection;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
