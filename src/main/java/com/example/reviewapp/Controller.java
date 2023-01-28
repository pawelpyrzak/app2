package com.example.reviewapp;

import org.springframework.web.bind.annotation.GetMapping;

public class Controller {
    @GetMapping("")
    public String homeSignUp(){
        return "index";
    }
}
