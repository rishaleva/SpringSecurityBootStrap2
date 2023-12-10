package ru.rishaleva.springBootSecurity.service;

import ru.rishaleva.springBootSecurity.model.User;

import java.util.List;

public interface UserService {
    User findByUserName(String name);

    User getUser(Long id);

    List<User> getAllUsers();

    void addUser(User user);

    void removeUser(Long id);

    void updateUser(User user);

}
