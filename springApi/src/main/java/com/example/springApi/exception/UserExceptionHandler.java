package com.example.springApi.exception;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.example.springApi.aspect.UserLogExecutionTime;
import com.example.springApi.model.User;

@Component
public class UserExceptionHandler extends Exception{
    User user;
    
    /** 
     * Verify all the exceptions to make sure that the user is conform to what we need
     * @param username
     * @param country
     * @param birthday
     * @return Exception
     * @throws Exception
     */
    @UserLogExecutionTime
    public void checkException(String username, String country, LocalDate birthday){
        if (isFieldNull(username, country, birthday)!=false){
            throw new ResponseStatusException(
            HttpStatus.EXPECTATION_FAILED, "Informations are missing, you need to give us your name, birthday date and country you live in");
        } else if(calculAge(birthday)<18){
            throw new ResponseStatusException(
            HttpStatus.EXPECTATION_FAILED, "You can't register here because you are not adult");
        } else if (!country.equalsIgnoreCase("France")){
            throw new ResponseStatusException(
            HttpStatus.EXPECTATION_FAILED, "You can't register here because you don't live in France");
        }
    }

    
    /** 
     * Calculate the age of the user
     * @param birthday
     * @return int
     */
    @UserLogExecutionTime
    public int calculAge(LocalDate birthday){
        LocalDate curDate = LocalDate.now();
        int age = Period.between(birthday, curDate).getYears();
        return age;
    }

    
    /** 
     * Check if a field is empty
     * @param username
     * @param country
     * @param birthday
     * @return boolean
     */
    @UserLogExecutionTime
    public boolean isFieldNull(String username, String country, LocalDate birthday){
        boolean isEmpty = false;
        if (username == null || username.isEmpty() || username.trim().isEmpty()) {
            isEmpty=true;
        } else if (country==null || country.isEmpty() || country.trim().isEmpty()){
            isEmpty=true;
        } else if (birthday== null){
            isEmpty=true;
        }
        return isEmpty;
    }
}
