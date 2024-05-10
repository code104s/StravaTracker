package com.code104s.StravaSortScore.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model, OAuth2AuthenticationToken authentication,
                            HttpSession session) {

        if (authentication != null) {
            OAuth2User user = authentication.getPrincipal();
            model.addAttribute("user", user.getAttributes());

            // Lay access token tu session
            String accessToken = (String) session.getAttribute("access_token");

            // su dung access token de lay thong tin cua nguoi dung
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + accessToken);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<String> response = restTemplate.exchange(
                    "https://www.strava.com/api/v3/athlete",
                    HttpMethod.GET,
                    entity,
                    String.class
            );
            model.addAttribute("athlete", response.getBody());

        }
        return "dashboard";
    }
}
