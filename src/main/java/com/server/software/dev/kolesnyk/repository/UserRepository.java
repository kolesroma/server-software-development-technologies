package com.server.software.dev.kolesnyk.repository;

import com.server.software.dev.kolesnyk.entity.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private final Map<Integer, User> users = new HashMap<>();

    public void create(User user) {
        users.put(user.getId(), user);
    }

    public User getById(int id) {
        return users.get(id);
    }

    public Collection<User> getAll() {
        return users.values();
    }

    public void update(User user, int id) {
        users.put(id, user);
    }

    public void delete(int id) {
        users.remove(id);
    }
}
