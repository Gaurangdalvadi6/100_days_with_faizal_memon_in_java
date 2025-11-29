package com.gaurang.first.app.service;

import com.gaurang.first.app.controller.UserController;
import com.gaurang.first.app.exception.UserNotFoundException;
import com.gaurang.first.app.model.User;
import com.gaurang.first.app.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //    private final Map<Integer, User> userDb = new HashMap<>();

    public User createUser(User user) {
//        userDb.putIfAbsent(user.getId(), user);
        return userRepository.save(user);
    }


    public User updatedUser(User user) {
//        if (!userDb.containsKey(user.getId())){
//            logger.error("error when finding user with id : {} ",user.getId());
//            throw new UserNotFoundException("User with ID " + user.getId() + " does not exist");
//        }
//        userDb.put(user.getId(), user);
//        return user;

        User exitingUser = userRepository.findById(user.getId()).orElseThrow(() -> new UserNotFoundException("User with ID " + user.getId() + " does not exist"));
        exitingUser.setEmail(user.getEmail());
        exitingUser.setName(user.getName());
        return userRepository.save(exitingUser);
    }

    public boolean deleteUser(int id) {
//        if (!userDb.containsKey(id)){
//            throw new UserNotFoundException("User with ID " + id + " does not exist");
//        }
//        userDb.remove(id);
//        return true;
        if (!userRepository.existsById(id)){
            throw new UserNotFoundException("User with ID " + id + " does not exist");
        }
        userRepository.deleteById(id);
        return true;
    }

    public List<User> getAllUser() {
//        if (userDb.isEmpty())
//            throw new NullPointerException("No user found found in db");
//        return new ArrayList<>(userDb.values());

        List<User> userList = userRepository.findAll();
        if (userList.isEmpty())
            throw new NullPointerException("No user found found in db");
        return userList;
    }

    public User getUserById(int id) {
//        if (!userDb.containsKey(id)){
//            throw new UserNotFoundException("User with ID " + id + " does not exist");
//        }
//        return userDb.get(id);
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with ID " + id + " does not exist"));
    }

    public List<User> searchUsers(String name, String email) {
//        return userDb.values().stream()
//                .filter(u -> u.getName().equalsIgnoreCase(name))
//                .filter(u -> u.getEmail().equalsIgnoreCase(email))
//                .toList();
//        return userRepository.findByNameAndEmail(name,email);

        if (name != null && email != null){
            return userRepository.findByNameIgnoreCaseAndEmailIgnoreCase(name,email);
        }

        if (name != null){
            return userRepository.findByNameIgnoreCase(name);
        }

        if (email != null){
            return userRepository.findByEmailIgnoreCase(email);
        }

        return Collections.emptyList();
    }
}
