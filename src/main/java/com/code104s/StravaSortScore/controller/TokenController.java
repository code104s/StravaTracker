package com.code104s.StravaSortScore.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class TokenController {


    @Value("${spring.security.oauth2.client.registration.strava.redirect-uri}")
    private String redirectUri;

    @GetMapping("/authorize")
    public String authorize(HttpSession session) {

        // Lấy clientId và clientSecret từ session
        String clientId = (String) session.getAttribute("clientId");
        String clientSecret = (String) session.getAttribute("clientSecret");

        // Redirect the user to the Strava authorization URL
        return "redirect:https://www.strava.com/oauth/authorize?client_id=" + clientId +
                "&redirect_uri=" + redirectUri +
                "&response_type=code&scope=activity:read_all";
    }

    @GetMapping("/exchange_token")
    public String exchangeToken(@RequestParam("code") String code,
                                                Model model,
                                                HttpSession session) throws JsonProcessingException {

        // Lấy clientId và clientSecret từ session
        String clientId = (String) session.getAttribute("clientId");
        String clientSecret = (String) session.getAttribute("clientSecret");

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        Map<String, String> params = new HashMap<>();
        params.put("client_id", clientId);
        params.put("client_secret", clientSecret);
        params.put("code", code);
        params.put("grant_type", "authorization_code");

        HttpEntity<Map<String, String>> request = new HttpEntity<>(params, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                "https://www.strava.com/oauth/token",
                HttpMethod.POST,
                request,
                String.class
        );

        // Convert the JSON response body to a Map
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Token:: " + response.getBody());
        Map<String, Object> responseBody = mapper.readValue(response.getBody(), new TypeReference<Map<String, Object>>(){});

        // Trích xuất mã truy cập và phạm vi từ phản hồi
        String accessToken = (String) responseBody.get("access_token");


        // Lưu trữ mã truy cập trong phiên
        session.setAttribute("access_token", accessToken);

        System.out.println("Access token: " + accessToken);

        // xac nhan nguoi dung da authention thanh cong
        session.setAttribute("isAuthenticated", true);

        // hien thi session da duoc luu co chua access token khong
        System.out.println("Session: " + session.getAttribute("access_token"));

        // Sau khi xử lý mã ủy quyền, chuyển hướng người dùng đến bảng điều khiển
        return "redirect:/dashboard";
    }
}
