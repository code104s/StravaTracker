package com.code104s.StravaSortScore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginConctroller {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
