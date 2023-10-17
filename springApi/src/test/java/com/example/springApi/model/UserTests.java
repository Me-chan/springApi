package com.example.springApi.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class UserTests {
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "Jean";
        User user = new User(" ", LocalDate.of(2000, 1, 8), "France");
        user.setUsername(username);
        assertEquals(user.getUsername(), username);
    }

    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        User instance = new User(" ", LocalDate.of(1995, 1, 8), "France");
        String expResult = "Marie";
        instance.setUsername("Marie");
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetCountry() {
        System.out.println("setCountry");
        String country = "France";
        User user = new User("Romuald", LocalDate.of(1982, 1, 8), " ");
        user.setCountry(country);
        assertEquals(user.getCountry(), country);
    }

    @Test
    public void testGetCountry() {
        System.out.println("getUsername");
        User instance = new User("Yui", LocalDate.of(2000, 1, 8), " ");
        String expResult = "France";
        instance.setCountry("France");
        String result = instance.getCountry();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetBirthday() {
        System.out.println("setBirthday");
        LocalDate birthday = LocalDate.of(1954, 5, 6);
        User user = new User("Georges", LocalDate.of(1953, 5, 6), "France");
        user.setBirthday(birthday);
        assertEquals(user.getBirthday(), birthday);
    }

    @Test
    public void testGetBirthday() {
        System.out.println("getBirthday");
        User user = new User("Hugo", LocalDate.of(1973, 12, 29), "France");
        LocalDate expResult = LocalDate.of(1979, 12, 29);
        user.setBirthday(LocalDate.of(1979, 12, 29));
        LocalDate result = user.getBirthday();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetPhoneNumber() {
        System.out.println("setPhoneNumber");
        String phoneNumber = "2235248945";
        User user = new User("Julie", LocalDate.of(1953, 5, 6), "France", " ", "F");
        user.setPhoneNumber(phoneNumber);
        assertEquals(user.getPhoneNumber(), phoneNumber);
    }

    @Test
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        User user = new User("Mylan", LocalDate.of(1965, 03, 19), "France", " ", "M");
        String expResult = "0621359758";
        user.setPhoneNumber("0621359758");
        String result = user.getPhoneNumber();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetGender() {
        System.out.println("setGender");
        String gender = "M";
        User user = new User("Luca", LocalDate.of(1953, 5, 6), "France", "0897563420 ", " ");
        user.setGender(gender);
        assertEquals(user.getGender(), gender);
    }

    @Test
    public void testGetGender() {
        System.out.println("getGender");
        User user = new User("Léonore", LocalDate.of(1943, 03, 19), "France", "0548975623 ", " ");
        String expResult = "F";
        user.setGender("F");
        String result = user.getGender();
        assertEquals(expResult, result);
    }
}
