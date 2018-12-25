package com.ss.business.service;

import java.util.HashSet;
import java.util.Set;

import com.ss.business.model.User;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private Set<User> users = new HashSet<>();

    public User findByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(User user) {
        users.add(user);
    }

    /**
     * @return the users
     */
    public Set<User> getUsers() {
        return users;
    }

}