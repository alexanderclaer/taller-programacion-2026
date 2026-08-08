package com.tallerprogramacion.infrastructure;

import java.util.List;

/**
 * Generic repository interface following the Dependency Inversion Principle.
 * High-level modules (services) depend on this abstraction, not on
 * concrete storage implementations.
 *
 * @param <T>  the entity type
 * @param <ID> the type of the entity's identifier
 */
public interface Repository<T, ID> {

    T findById(ID id);

    void save(T entity);

    List<T> findAll();

    void deleteById(ID id);
}