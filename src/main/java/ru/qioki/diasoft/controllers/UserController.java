package ru.qioki.diasoft.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.qioki.diasoft.models.User;
import ru.qioki.diasoft.services.UserService;

import java.util.List;

@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping("/users")
    private List getAllUsers() {
        logger.info("get /users access");
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    private User getUserById(@PathVariable("id") int id) {
        logger.info(String.format("get /users/%s access", id));
        return userService.getUserById(id);
    }

    @DeleteMapping("/users/{id}")
    private void deleteUser(@PathVariable("id") int id) {
        logger.info(String.format("delete /users/%s access", id));
        userService.delete(id);
    }

    @PostMapping("/users")
    private int saveUser(@RequestBody User user) {
        userService.saveOrUpdate(user);
        logger.info(String.format("post /users/%s access", user.getId()));
        return user.getId();
    }

}
