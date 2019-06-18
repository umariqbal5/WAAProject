package com.exam.waaproject.services;


import com.exam.waaproject.domain.User;

import java.util.List;


public interface UserService {
    User findByUsername(String username);
    List<User> findAllUsers();

}
