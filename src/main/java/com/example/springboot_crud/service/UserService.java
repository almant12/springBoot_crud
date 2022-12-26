package com.example.springboot_crud.service;
import com.example.springboot_crud.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    void deleteUserById(Long id);

}
