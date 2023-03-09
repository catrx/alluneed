package com.project.alluneed.controller;

import com.project.alluneed.api.UsersApi;
import com.project.alluneed.model.User;
import com.project.alluneed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UsersApi {
    private final UserService userService;

    @Autowired
    public UserController(UserService usersService) {
        this.userService = usersService;
    }


    @Override
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> ret = userService.findAllUsers();
        return ResponseEntity.ok(ret);
    }

    @Override
    public ResponseEntity<User> addUser(User user) {
        User createdUser = this.userService.addUser(user);
        return ResponseEntity.ok(createdUser);
    }
}
