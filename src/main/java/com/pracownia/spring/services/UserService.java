package com.pracownia.spring.services;

import com.pracownia.spring.entities.User;

public interface UserService {
    User saveUser(User user);
    User findUserByLogin(String login);
    Iterable<User> getAllUsers();
    Iterable<User> AllUsersPaging(Integer pageNr, Integer howManyOnPage);
    void deleteUser(String login);
}
