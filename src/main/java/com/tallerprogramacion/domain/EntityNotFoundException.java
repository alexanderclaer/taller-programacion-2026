package com.tallerprogramacion.domain;

/**
 * Thrown when a requested entity (e.g., an Account) cannot be found.
 */
public class EntityNotFoundException extends DomainException {

    public EntityNotFoundException(String entityName, String id) {
        super(entityName + " not found with id: " + id);
    }
}