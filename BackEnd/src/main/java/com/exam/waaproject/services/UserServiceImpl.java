package com.exam.waaproject.services;

import com.exam.waaproject.domain.User;
import com.exam.waaproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return (User) userRepository.findByUsername(username).get();
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }
}
