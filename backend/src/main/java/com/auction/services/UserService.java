package com.auction.services;

import com.auction.entities.User;

public interface UserService {
    User saveUser(User user);
    User findUserByLogin(String login);
    Iterable<User> getAllUsers();
    Iterable<User> AllUsersPaging(Integer pageNr, Integer howManyOnPage);
    void deleteUser(String login);
}
