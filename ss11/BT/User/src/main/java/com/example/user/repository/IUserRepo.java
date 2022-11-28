package com.example.user.repository;

import com.example.user.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepo {
    List<User> getAll();
    void insertUser(User user);
    User findById(int id);
    void deleteById(int id);
    void update(User user);
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
