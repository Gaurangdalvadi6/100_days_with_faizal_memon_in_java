package com.example.controller;

import org.springframework.stereotype.Controller;
import com.example.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser(String name){
        userService.addUser(name);
        System.out.println("User added : " + name);
    }

    public void getAllUser(){
        List<String> users = userService.getAllUser();
        System.out.println("All users : " + users);
    }
}
