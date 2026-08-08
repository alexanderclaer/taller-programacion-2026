package com.tallerprogramacion.domain;

/**
 * Base abstract exception for the entire application.
 * All custom exceptions must extend this class, directly or indirectly.
 */
public abstract class AppException extends RuntimeException {

    protected AppException(String message) {
        super(message);
    }

    protected AppException(String message, Throwable cause) {
        super(message, cause);
    }
}