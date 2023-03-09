package com.project.alluneed.api;

import com.project.alluneed.model.User;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping()
public interface UsersApi {

    @GetMapping("/users")
    ResponseEntity<List<User>> findAllUsers() throws ParseException;

    @PostMapping("/users")
    ResponseEntity<User> addUser(@RequestBody User user) throws ParseException;
}
