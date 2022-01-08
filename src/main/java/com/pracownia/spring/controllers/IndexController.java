package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.*;
import com.pracownia.spring.services.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping(value = "")
    public String index() {
        return "Welcome to our auction page!";
    }


}