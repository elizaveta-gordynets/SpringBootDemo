package com.example.springbootdemo.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ConstraintViolationError extends RuntimeException {

    private String message;
}
