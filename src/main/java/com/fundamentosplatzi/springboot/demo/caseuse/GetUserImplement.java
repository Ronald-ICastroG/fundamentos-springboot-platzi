package com.fundamentosplatzi.springboot.demo.caseuse;

import com.fundamentosplatzi.springboot.demo.entity.User;
import com.fundamentosplatzi.springboot.demo.service.UserService;

import java.util.List;

public class GetUserImplement implements GetUser{

    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService=userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
