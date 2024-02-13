package com.ca.core.exception;

public class AuthenticationException extends Exception {
    private String code;

    public AuthenticationException(String message, String code) {
        super(message);
        this.code = code;
    }
}
