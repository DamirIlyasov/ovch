package com.lukyanov.repository;

import com.lukyanov.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByEmail(String email);

}
