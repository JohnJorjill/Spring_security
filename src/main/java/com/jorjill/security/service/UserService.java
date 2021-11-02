package com.jorjill.security.service;

import com.jorjill.security.domain.Role;
import com.jorjill.security.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
