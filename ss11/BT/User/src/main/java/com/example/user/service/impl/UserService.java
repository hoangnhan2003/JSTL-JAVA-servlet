package com.example.user.service.impl;

import com.example.user.model.User;
import com.example.user.repository.impl.UserRepository;
import com.example.user.service.IUserService;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {
    UserRepository userRepository = new UserRepository();
    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User selectUserById(int id) {
        User user = userRepository.findById(id);
        return user;
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void addUser(User user) {
        userRepository.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.update(user);
    }

    @Override
    public List<User> findByCountry(String country) {
        return userRepository.findByCountry(country);
    }

    @Override
    public List<User> sortByName() {
        return userRepository.sortByName();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        userRepository.insertUserStore(user);
    }

    @Override
    public void addUserTransaction(User user, int[] permision) {
        userRepository.addUserTransaction(user,permision);
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        userRepository.insertUpdateWithoutTransaction();
    }

    @Override
    public void insertUpdateWithTransaction() {
        userRepository.insertUpdateWithTransaction();
    }

    @Override
    public List<User> displayUsersByProcedure() {
        return userRepository.displayUsersByProcedure();
    }

    @Override
    public void deleteUserByProcedure(int id) {
        userRepository.deleteUserByProcedure(id);
    }

    @Override
    public void updateUserByProcedure(User user) {
        userRepository.updateUserByProcedure(user);
    }
}
