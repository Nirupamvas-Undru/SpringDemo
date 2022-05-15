package com.springboot.resortmanagement.exception;

public class ResortNotFoundException extends RuntimeException{
    public ResortNotFoundException(String message) {
        super(message);
    }

    public ResortNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResortNotFoundException(Throwable cause) {
        super(cause);
    }
}
