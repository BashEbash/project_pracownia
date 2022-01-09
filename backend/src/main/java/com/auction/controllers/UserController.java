package com.auction.controllers;

import com.auction.entities.User;
import com.auction.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "user/{login}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable String login) {
        return userService.findUserByLogin(login);

    }

    @GetMapping(value = "users", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();

    }

    @GetMapping(value = "users/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<User> getUsersPage(@PathVariable Integer page) {
        return userService.AllUsersPaging(page, 5);

    }

    @PostMapping(value = "createUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object createUser(@RequestParam HashMap<String, String> user_data) {

        String name = user_data.get("name");
        String surname = user_data.get("surname");
        String address_of_residence = user_data.get("address_of_residence");
        String adres_mail = user_data.get("adres_mail");
        User user = null;
        try {
            user = new User(name, surname, address_of_residence, adres_mail);
        }catch (NullPointerException e){
            return "Adres mail is empty";
        }

        userService.saveUser(user);

        return user;
    }

    @DeleteMapping(value = "user/{login}")
    public ResponseEntity deleteUser(@PathVariable String login) {
        userService.deleteUser(login);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping(value = "/user/edit")
    public ResponseEntity editUser(@RequestBody User user) {

        if(userService.findUserByLogin(user.getLogin()) == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }




}
