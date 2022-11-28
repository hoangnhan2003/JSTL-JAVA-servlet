package com.example.user.service;

import com.example.user.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    List<User> getAll();
    User selectUserById(int id);
    void deleteUserById(int id);
    void addUser(User user);
    void updateUser(User user);
    List<User> findByCountry(String country);
    List<User> sortByName();
    User getUserById(int id);
    void insertUserStore(User user) throws SQLException;
    void addUserTransaction(User user, int[] permision);
    void insertUpdateWithoutTransaction();
    void insertUpdateWithTransaction();
    List<User> displayUsersByProcedure();
    void deleteUserByProcedure(int id);
    void updateUserByProcedure(User user);

}
