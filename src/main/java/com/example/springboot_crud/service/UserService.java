package com.example.springboot_crud.service;
import com.example.springboot_crud.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    void deleteUserById(Long id);

   User findUserById(Long id);

   Page<User> findPaginated(Integer pageNo,Integer pageSize);
   List<User> findByKeyword(String keyword);
}
