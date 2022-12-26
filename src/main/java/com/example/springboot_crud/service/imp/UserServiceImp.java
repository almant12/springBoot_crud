package com.example.springboot_crud.service.imp;

import com.example.springboot_crud.model.User;
import com.example.springboot_crud.repository.UserRepository;
import com.example.springboot_crud.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Page<User> findPaginated(Integer pageNo, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNo - 1,pageSize);
        return userRepository.findAll(pageable);
    }

}
