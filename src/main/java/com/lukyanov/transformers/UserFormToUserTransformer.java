package com.lukyanov.transformers;

import com.lukyanov.model.User;
import com.lukyanov.util.UserForm;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.function.Function;


public class UserFormToUserTransformer implements Function<UserForm, User> {

    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public User apply(UserForm userForm) {
        User user = new User();
        user.setPhone(userForm.getPhone());
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        user.setEmail(userForm.getEmail());
        user.setAge(userForm.getAge());
        user.setPassword(encoder.encode(userForm.getPassword()));
        return user;
    }

}
