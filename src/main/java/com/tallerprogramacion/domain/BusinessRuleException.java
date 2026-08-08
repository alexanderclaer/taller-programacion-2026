package com.tallerprogramacion.domain;

/**
 * Thrown when an operation violates a core business rule
 * (e.g., withdrawing more than the available balance).
 */
public class BusinessRuleException extends DomainException {

    public BusinessRuleException(String message) {
        super(message);
    }
}