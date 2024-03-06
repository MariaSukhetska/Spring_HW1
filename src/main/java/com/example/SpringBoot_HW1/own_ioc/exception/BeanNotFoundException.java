package com.example.SpringBoot_HW1.own_ioc.exception;

public class BeanNotFoundException extends RuntimeException {
    public BeanNotFoundException(String message) {
        super(message);
    }
}
