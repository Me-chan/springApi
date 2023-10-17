package com.example.springApi.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
/**
 * Interface that is used to the methods it shows the time and permits to show the differents user log
 */
public @interface UserLogExecutionTime {
    
}
