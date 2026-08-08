package com.tallerprogramacion.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base exception for all business/domain-level errors.
 * Extends AppException, forming the second level of the hierarchy.
 */
public abstract class DomainException extends AppException {

    private static final Logger logger = LoggerFactory.getLogger(DomainException.class);

    protected DomainException(String message) {
        super(message);
        logger.warn("Domain exception raised: {}", message);
    }
}