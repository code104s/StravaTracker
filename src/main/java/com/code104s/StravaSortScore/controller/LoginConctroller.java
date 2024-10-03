package com.code104s.StravaSortScore.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginConctroller {
    
    @GetMapping("/")
    public String home() {
        // Redirect the user to the Strava authorization URL
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/loginStrava")
    public String handleLogin(@RequestParam("clientId") String clientId,
                              @RequestParam("clientSecret") String clientSecret,
                              HttpSession session) {

        // Lưu clientId và clientSecret vào session
        session.setAttribute("clientId", clientId);
        session.setAttribute("clientSecret", clientSecret);

        return "redirect:/authorize";
    }

}
