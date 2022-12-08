package com.example.demo.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private String userName = "root";
    private String password ="";
    private String jdbcURL = "jdbc:mysql://localhost:3306/testcasestudy?useSSL=false";
    private Connection connection;
    public Connection getConnectionJAVAtoDB(){
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
