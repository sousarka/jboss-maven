package com.ss.web.controller;

import com.ss.business.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
@RequestMapping("/hello")
public class HelloController {

    private static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/sayHello")
    public @ResponseBody User sayHello(@RequestBody String name) {
        LOGGER.info("name in sayHello", name);
        User user = new User();
        user.setName(name);
        return user;
    }

}