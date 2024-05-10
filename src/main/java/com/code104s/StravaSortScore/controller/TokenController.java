package com.code104s.StravaSortScore.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Controller

public class TokenController {

    @Value("${spring.security.oauth2.client.registration.strava.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.strava.client-secret}")
    private String clientSecret;

    @Value("${spring.security.oauth2.client.registration.strava.redirect-uri}")
    private String redirectUri;

    @GetMapping("/authorize")
    public String authorize() {
        // Redirect the user to the Strava authorization URL
        return "redirect:https://www.strava.com/oauth/authorize?client_id=" + clientId +
                "&redirect_uri=" + redirectUri +
                "&response_type=code&scope=activity:read_all";
    }

    @GetMapping("/exchange_token")
    public String exchangeToken(@RequestParam("code") String code, HttpSession session) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        Map<String, String> params = new HashMap<>();
        params.put("client_id", clientId);
        params.put("client_secret", clientSecret);
        params.put("code", code);
        params.put("grant_type", "authorization_code");

        HttpEntity<Map<String, String>> request = new HttpEntity<>(params, headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                "https://www.strava.com/oauth/token",
                HttpMethod.POST,
                request,
                Map.class
        );

        Map<String, Object> responseBody = response.getBody();
        String accessToken = (String) responseBody.get("access_token");

        // Store the access token in the session
        session.setAttribute("access_token", accessToken);

        // After processing the authorization code, redirect the user to the dashboard
        return "redirect:/dashboard";
    }

}