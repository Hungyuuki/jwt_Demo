package com.pmhung2.demojwt.Service;

import com.pmhung2.demojwt.domain.Role;
import com.pmhung2.demojwt.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
