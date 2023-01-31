package com.example.SpringBoot.service;

import com.example.SpringBoot.DAO.UserDAO;
import com.example.SpringBoot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User getOneUser(int id) {
        return userDAO.getOneUser(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}
