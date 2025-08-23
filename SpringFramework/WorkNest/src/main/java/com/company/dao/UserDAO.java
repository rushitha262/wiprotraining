package com.company.dao;


import com.company.model.User;
import java.util.List;

public interface UserDAO {
    User save(User user);                // save or update a user
    User findById(Integer id);           // find user by id
    User findByEmail(String email);      // find by email
    List<User> findAll();                // list all users
    void delete(User user);              // delete user
}
