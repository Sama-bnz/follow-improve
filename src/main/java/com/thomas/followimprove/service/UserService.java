package com.thomas.followimprove.service;

import com.thomas.followimprove.entities.User;
import com.thomas.followimprove.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public User create (User user) {
        return userRepository.save(user);
    }
}
