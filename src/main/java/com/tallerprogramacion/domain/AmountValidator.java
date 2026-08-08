package com.tallerprogramacion.domain;

import java.math.BigDecimal;

/**
 * Functional interface representing a validation rule for monetary amounts.
 * Can be implemented with lambda expressions or method references.
 */
@FunctionalInterface
public interface AmountValidator {

    /**
     * Validates the given amount.
     * @return true if the amount is valid according to this rule.
     */
    boolean isValid(BigDecimal amount);
}