package com.example.UserAuthentication.exception;

public class AlreadyExistsException extends RuntimeException{

    public AlreadyExistsException(final String message) {
        super(message);
    }
}
