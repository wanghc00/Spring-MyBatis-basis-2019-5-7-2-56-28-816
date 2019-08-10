package com.example.demo.controller;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public List<User> findAll() {
        return userMapper.getAllUser();
    }

    @GetMapping("/getUserById/{userId}")
    public User findById(@PathVariable int userId) {
        return userMapper.getUserById(userId);
    }

    @PostMapping("/insertUser")
    public void insertUser(@RequestBody User user) {
        userMapper.insertUser(user);
    }

    @PutMapping("/updateUserById/{userId}")
    public void updateUser(@RequestBody User user, @PathVariable int userId) {
        userMapper.updateUserById(user, userId);
    }

    @DeleteMapping("/deleteUserById/{userId}")
    public void deleteById(@PathVariable int userId) {
        userMapper.deleteUserById(userId);
    }
}