package com.tallerprogramacion.domain;

import java.math.BigDecimal;

/**
 * Helper class providing a static method used as a method reference
 * for AmountValidator.
 */
public class AmountValidatorHelper {

    public static boolean isNotNull(BigDecimal amount) {
        return amount != null;
    }
}