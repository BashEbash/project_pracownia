package com.pracownia.spring.services;

import com.pracownia.spring.entities.User;
import com.pracownia.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserServicelmpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Iterable<User> AllUsersPaging(Integer pageNr, Integer howManyOnPage) {
        return userRepository.findAll(PageRequest.of(pageNr, howManyOnPage));
    }

    @Override
    public void deleteUser(String login) {
        userRepository.delete(userRepository.findUserByLogin(login));
    }

}
