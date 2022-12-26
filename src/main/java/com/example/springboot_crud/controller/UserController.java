package com.example.springboot_crud.controller;

import com.example.springboot_crud.model.User;
import com.example.springboot_crud.repository.UserRepository;
import com.example.springboot_crud.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {


    private final UserService userService;


    @GetMapping("/")
    public String getAllUsers(Model model){
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users",userList);
        return "index";
    }

    @GetMapping("/addUser")
    public String addUser(Model model){
        User user = new User();
        model.addAttribute("addUser",user);
        return "addUser";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUserById(@PathVariable("id")Long id){
        userService.deleteUserById(id);
        return "redirect:/";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id")Long id,Model model){
        model.addAttribute("user",userService.findUserById(id));
        return "updateUser";
    }


}
