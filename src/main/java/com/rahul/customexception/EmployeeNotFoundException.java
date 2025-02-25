package com.rahul.customexception;

public class EmployeeNotFoundException extends RuntimeException {

    // Constructor with a message
    public EmployeeNotFoundException(String message) {
        super(message);
    }

    // Constructor with message and cause
    public EmployeeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}