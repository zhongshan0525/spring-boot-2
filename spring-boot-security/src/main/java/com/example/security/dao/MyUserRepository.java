package com.example.security.dao;

import com.example.security.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser,Integer> {

    MyUser findByUsername(String username);
}
