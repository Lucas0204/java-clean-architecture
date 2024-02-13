package com.ca.core.exception;

public class CreateUserException extends Exception {
    private String code;
    public CreateUserException(String message, String code) {
        super(message);
        this.code = code;
    }
}
