package com.example.springbootdemo.exceptions;

public class ItemNotFoundException extends RuntimeException {
    private final static Long id = 1L;

    public ItemNotFoundException(String message) {
        super(message);
    }
}
