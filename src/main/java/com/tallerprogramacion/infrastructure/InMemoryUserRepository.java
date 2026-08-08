package com.tallerprogramacion.infrastructure;

import com.tallerprogramacion.domain.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {
    private final Map<String, User> users = new HashMap<>();

    @Override
    public User findById(String email) {
        return users.get(email);
    }

    @Override
    public void save(User entity) {
        users.put(entity.getEmail(), entity);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void deleteById(String email) {
        users.remove(email);
    }
}