package com.thomas.followimprove.controller;

import com.thomas.followimprove.entities.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public User create(@RequestBody User user) {
        user.setId(1);
        return user;
    }

}
