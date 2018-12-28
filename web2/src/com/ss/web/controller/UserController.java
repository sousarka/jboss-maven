package com.ss.web.controller;

import java.util.Locale;

import com.ss.business.model.Result;
import com.ss.business.model.User;
import com.ss.business.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/users")
public class UserController {

    private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/findByName")
    public @ResponseBody Result<User> findByName(@RequestBody String name) {
        Result<User> result = new Result<>();
        LOGGER.info("getUserByName : {}", name);
        User user = userService.findByName(name);
        if (user == null) {
            result.setMessage(messageSource.getMessage("user.not.found", new Object[] {name}, Locale.US));
        } else {
            result.setMessage(messageSource.getMessage("user.found", new Object[] {name}, Locale.US));
            result.setRetObject(user);
        }
        return result;
    }

    @RequestMapping(value = "/addUser")
    public @ResponseBody Result<Void> addUser(@RequestBody User user) {
        Result<Void> result = new Result<>();
        LOGGER.info("addUser : {}", user);
        userService.addUser(user);
        result.setMessage(messageSource.getMessage("user.added", null, Locale.US));
        return result;
    }

}