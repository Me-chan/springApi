package com.example.springApi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.springApi.exception.UserExceptionHandler;
import com.example.springApi.model.User;
import com.example.springApi.repository.UserRepository;
import com.example.springApi.aspect.UserLogExecutionTime;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private UserExceptionHandler userException;
    
    /** 
     * Constructor to initialize UserExceptionHandler
     */
    public UserService(UserExceptionHandler userException) {
        this.userException = userException;
    }

    
    /** 
     * @param user
     * @return Object
     */
    @UserLogExecutionTime
    public User saveUsersService(User user){
        userException.checkException(user.getUsername(), user.getCountry(), user.getBirthday(), user.getPhoneNumber());
        user= userRepository.save(user);
        return user;
    }


    
    /** 
     * @param username
     * @return ResponseEntity<Object>
     */
    @UserLogExecutionTime
    public List<User> getUserByUsernameService(String username){
        List<User> user = userRepository.findUserByUsername(username);
        return user;
    }
}
