package com.lukyanov.service.impl;

import com.lukyanov.model.User;
import com.lukyanov.repository.UserRepository;
import com.lukyanov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findOneByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }
}
