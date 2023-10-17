package com.example.springApi.model;

import java.time.LocalDate;

import com.example.springApi.aspect.UserLogExecutionTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@Table(name = "Users")
/**
 * this class represents our table and table's column, it also creates the getters, setters and constructors
 */
public class User {
    @Id
    @Column(name = "USERNAME")
    private String username ;

    @Column(name = "BIRTHDAY")
    private LocalDate birthday ;

    @Column(name = "COUNTRY")
    private String country ;

    @Column(name = "PHONENUMBER")
    private String phoneNumber;

    @Column(name = "GENDER")
    private String gender;

    /**
     * Default constructor
     */
    public User(){
    }

    /** 
     * constructor with mandatory informations
     */
    public User(String name, LocalDate birthday, String country ){
        this.username = name;
        this.birthday = birthday;
        this.country = country;
    }

    /** 
     * constructor with optional informations
     */
    public User(String name, LocalDate birthday, String country, String phoneNumber, String gender){
        this.username = name;
        this.birthday = birthday;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.gender=gender;
    }

    
    /** 
     * getter
     * @return String
     */
    @UserLogExecutionTime
    public String getUsername(){
        return username;
    }

    
    /** 
     * setter
     * @param username
     */
    @UserLogExecutionTime
    public void setName(String username){
        this.username = username;
    }

    
    /** 
     * getter
     * @return LocalDate
     */
    @UserLogExecutionTime
    public LocalDate getBirthday(){
        return birthday;
    }

    
    /** 
     * setter
     * @param birthday
     */
    @UserLogExecutionTime
    public void setBirthday(LocalDate birthday){
        this.birthday = birthday;
    }

    
    /** 
     * getter
     * @return String
     */
    @UserLogExecutionTime
    public String getCountry(){
        return country;
    }

    
    /** 
     * setter
     * @param country
     */
    @UserLogExecutionTime
    public void setCountry(String country){
        this.country = country;
    }

    
    /** 
     * getter
     * @return String
     */
    @UserLogExecutionTime
    public String getPhoneNumber(){
        return phoneNumber;
    }

    
    /** 
     * setter
     * @param phoneNumber
     */
    @UserLogExecutionTime
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    
    /** 
     * getter
     * @return String
     */
    @UserLogExecutionTime
    public String getGender(){
        return gender;
    }

    
    /** 
     * setter
     * @param gender
     */
    @UserLogExecutionTime
    public void setGender(String gender){
        this.gender = gender;
    }
}
