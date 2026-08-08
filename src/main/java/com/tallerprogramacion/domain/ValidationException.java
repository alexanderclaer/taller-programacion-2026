package com.tallerprogramacion.domain;

/**
 * Thrown when input data fails validation rules
 * (e.g., a negative deposit amount).
 */
public class ValidationException extends DomainException {

    public ValidationException(String message) {
        super(message);
    }
}