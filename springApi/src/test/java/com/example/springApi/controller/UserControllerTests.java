package com.example.springApi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.springApi.model.User;
import com.example.springApi.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTests {
    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Test
    public void saveUsersTest() throws Exception{ 
        System.out.println("saveUsers");

        User user = new User();
        user.setUsername("Ana");
        user.setCountry("Français");
        user.setBirthday(LocalDate.of(2000,10,28));
        
        ResponseEntity<Object> response = userController.saveUsers(user);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals("Utilisateur créé avec succès", response.getBody());

        verify(userService, times(1)).saveUsersService(user);
    }

    @Test
    public void getUserByUsernameTest(){ 
        System.out.println("getUserByUsername");
        User user = new User();
        user.setUsername("Clement");
        user.setBirthday(LocalDate.of(1993, 8, 27));
        user.setCountry("France");
        ResponseEntity<Object> responseEntity = userController.getUserByUsername("Clement");

        
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
