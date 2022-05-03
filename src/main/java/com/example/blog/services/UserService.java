package com.example.blog.services;

import com.example.blog.entities.User;

public interface UserService {
    User findByUserName(String name);
    void saveUser(User user);
}
