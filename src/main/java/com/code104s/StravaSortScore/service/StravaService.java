package com.code104s.StravaSortScore.service;

import com.code104s.StravaSortScore.entity.Activity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class StravaService {

    // Tao bien static final de luu tru URL cua Strava API
    private static final String STRAVA_API_URL = "https://www.strava.com/api/v3/athlete/activities";

    // Tao doi tuong RestTemplate
    private RestTemplate restTemplate;

    // Tao constructor
    public StravaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Tao phuong thuc getActitvity de lay thong tin cua mot hoat dong dua tren id va accessToken
    public Activity getActitvity(String id, String accessToken) {
        ResponseEntity<Activity> response = restTemplate.exchange(STRAVA_API_URL + "/" + id + "?access_token=" + accessToken, HttpMethod.GET, null, Activity.class);
        return response.getBody();
    }
}
