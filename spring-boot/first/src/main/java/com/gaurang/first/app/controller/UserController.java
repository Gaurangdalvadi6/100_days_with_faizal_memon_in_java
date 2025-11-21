package com.gaurang.first.app.controller;

import com.gaurang.first.app.service.UserService;
import com.gaurang.first.app.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        logger.trace("Creating user... trace");
        logger.debug("Creating user... debug");
        logger.info("Creating user... info");
        logger.warn("Creating user... warn");
        logger.error("Creating user... error");
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updated = userService.updatedUser(user);
        if (updated == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(updated);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        List<User> users =userService.getAllUser();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        boolean isDeleted =userService.deleteUser(id);
        if (!isDeleted){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body("User deleted");

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id){
        User user =userService.getUserById(id);
        if (user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUser(@RequestParam(required = false,defaultValue = "gaurang") String name,
                                                 @RequestParam(required = false) String email){

        return ResponseEntity.ok(userService.searchUsers(name,email));
    }

    @GetMapping("/info")
    public String getInfo(@RequestHeader("User-agent") String userAgent){
        return "User Agent: "+ userAgent;
    }
}
