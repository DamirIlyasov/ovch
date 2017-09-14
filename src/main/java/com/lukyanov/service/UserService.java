package com.lukyanov.service;

import com.lukyanov.model.User;

import java.util.List;


public interface UserService {

    User findOneByEmail(String email);
    void add(User user);
}
