package com.example.springApi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.springApi.model.User;
import com.example.springApi.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepo;

    @Test
    public void saveUsersService() throws Exception{ 
        System.out.println("saveUsers with good user");

        User user = new User();
        user.setUsername("Jeanne");
        user.setCountry("Français");
        user.setBirthday(LocalDate.of(1962,3,14));
        
        User response = userRepo.save(user);
        assertNull(response);
    }

    @Test
    public void getUserByUsernameService(){
        System.out.println("getUserbyUsernameService");

        User user = new User("Lily",LocalDate.of(1978,4,12), "Français");

        when(userRepo.findUserByUsername("Lily")).thenReturn(Collections.singletonList(user));

        List<User> response = userRepo.findUserByUsername("Lily");

        assertNotNull(response);
        assertFalse(response.isEmpty());
        User actualUser = response.get(0);
        assertEquals(user.getUsername(), actualUser.getUsername());
        assertEquals(user.getCountry(), actualUser.getCountry());
        assertEquals(user.getBirthday(), actualUser.getBirthday());

    }
}
