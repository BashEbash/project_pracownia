package com.auction.controllers;


import com.auction.entities.*;
import com.auction.services.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping(value = "")
    public String index() {
        return "Welcome to our auction page!";
    }


}