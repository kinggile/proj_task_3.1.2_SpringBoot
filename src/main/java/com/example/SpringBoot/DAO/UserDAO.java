package com.example.SpringBoot.DAO;



import com.example.SpringBoot.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    void save(User user);

    User getOneUser(int id);

    public void updateUser(User user);
    void deleteUser(int id);

}
