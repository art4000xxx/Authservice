package com.example.authservice.exception;

public class UnauthorizedUser extends RuntimeException {
    public UnauthorizedUser(String message) {
        super(message);
    }
}