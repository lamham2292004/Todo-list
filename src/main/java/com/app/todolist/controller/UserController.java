package com.app.todolist.controller;

import com.app.todolist.dto.request.UserCreateRequest;
import com.app.todolist.dto.request.UserUpdateRequest;
import com.app.todolist.dto.response.UserResponse;
import com.app.todolist.entity.User;
import com.app.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    User createUser(@RequestBody UserCreateRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    List<User> getUsers() {
        return userService.getUser();
    }

    @GetMapping("/{userId}")
    UserResponse getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }
    @PutMapping("/{userId}")
    public UserResponse updateUser(@PathVariable Long userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId,request);
    }
    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        return "User deleted";
    }
}
