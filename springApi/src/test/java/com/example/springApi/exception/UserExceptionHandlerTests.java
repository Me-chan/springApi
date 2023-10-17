package com.example.springApi.exception;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.example.springApi.model.User;

public class UserExceptionHandlerTests {
    @Test
    public void checkEachExceptionTest() throws Exception{
        System.out.println("checkEachException");
        try {
            new User("Judith", LocalDate.of(2015,5,15), "France");
        } catch(Exception exception){
            assert(exception.getMessage().contains("not adult"));
        }
        try {
            new User("Sam", LocalDate.of(2000,5,15), "USA");
        } catch(Exception exception){
            assert(exception.getMessage().contains("You can't register here because you are not in France"));
        }
        try {
            new User("Nicolas", LocalDate.of(2015,5,15), "Suisse");
        } catch(Exception exception){
            assert(exception.getMessage().contains("You can't register here because you are not an adult and not in France"));
        }
    }

    @Test
    public void checkNotNullExceptionTest() throws Exception{
        System.out.println("checkNotNullException");
        try {
            new User(null, null, null);
        } catch(Exception exception){
            assert(exception.getMessage().contains("You need to give the mandatory informations to register"));
        }
        try {
            new User(null, LocalDate.of(2000,5,15), null);
        } catch(Exception exception){
            assert(exception.getMessage().contains("You need a name and a country to register"));
        }
        try {
            new User(null, null, "France");
        } catch(Exception exception){
            assert(exception.getMessage().contains("You need a name and a birthday date to register"));
        }
        try {
            new User("Charlotte", null, null);
        } catch(Exception exception){
            assert(exception.getMessage().contains("You need a birthday date and a country to register"));
        }
        try {
            new User("Charlotte", LocalDate.of(2000,5,15), null);
        } catch(Exception exception){
            assert(exception.getMessage().contains("You need a country to register"));
        }
        
        try {
            new User(null, LocalDate.of(2000,5,15), "France");
        } catch(Exception exception){
            assert(exception.getMessage().contains("You need a name to register"));
        }
        
        try {
            new User("Charlotte", null, "France");
        } catch(Exception exception){
            assert(exception.getMessage().contains("You need a country to register"));
        }
    }
}
