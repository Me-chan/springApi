package com.example.springApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springApi.model.User;

/** 
* Interface that permit to use the JpaRepository to find the user with their username and save them
*/
public interface UserRepository extends JpaRepository<User, String>{
    List<User> findUserByUsername(String username);
}
