package com.example.springApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springApi.model.User;
import com.example.springApi.service.UserService;
import com.example.springApi.aspect.UserLogExecutionTime;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * a function that saves a user if he's valid and sends a message depending on the error if not
     * @param user : User
     * @return : String
     * @throws Exception
     */
    @UserLogExecutionTime
    @PostMapping("/api/users/add")
    public ResponseEntity<Object> saveUsers(@RequestBody User user){
        userService.saveUsersService(user);
        return ResponseEntity.ok("Utilisateur créé avec succès");
    }

    /**
     * a function that gets you a user's data depending on his username
     * @param username : String
     * @return : ResponseEntity<User>
     */
    @UserLogExecutionTime
    @GetMapping("api/users/{username}")
    public ResponseEntity<Object> getUserByUsername(@PathVariable String username){
        List<User> user = userService.getUserByUsernameService(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return new ResponseEntity<Object>("not found" , HttpStatus.NOT_FOUND);
        }
    }
    
}
