package com.gaurang.first.app.service;

import com.gaurang.first.app.controller.UserController;
import com.gaurang.first.app.exception.UserNotFoundException;
import com.gaurang.first.app.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final Map<Integer, User> userDb = new HashMap<>();

    public User createUser(User user) {
        userDb.putIfAbsent(user.getId(), user);
        return user;
    }


    public User updatedUser(User user) {
        if (!userDb.containsKey(user.getId())){
            logger.error("error when finding user with id : {} ",user.getId());
            throw new UserNotFoundException("User with ID " + user.getId() + " does not exist");
        }
        userDb.put(user.getId(), user);
        return user;
    }

    public boolean deleteUser(int id) {
        if (!userDb.containsKey(id)){
            throw new UserNotFoundException("User with ID " + id + " does not exist");
        }
        userDb.remove(id);
        return true;
    }

    public List<User> getAllUser() {
        if (userDb.isEmpty())
            throw new NullPointerException("No user found found in db");
        return new ArrayList<>(userDb.values());
    }

    public User getUserById(int id) {
        if (!userDb.containsKey(id)){
            throw new UserNotFoundException("User with ID " + id + " does not exist");
        }
        return userDb.get(id);
    }

    public List<User> searchUsers(String name, String email) {
        return userDb.values().stream()
                .filter(u -> u.getName().equalsIgnoreCase(name))
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .toList();
    }
}
