package com.code104s.StravaSortScore.controller;

import com.code104s.StravaSortScore.DAO.AthleteRepository;
import com.code104s.StravaSortScore.DAO.ClubActivitiesRepository;
import com.code104s.StravaSortScore.entity.Athlete;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class DashboardController {

    @Autowired
    private final AthleteRepository athleteRepository;

    @Autowired
    private final ClubActivitiesRepository clubActivitiesRepository;

    @Autowired
    public DashboardController(AthleteRepository athleteRepository, ClubActivitiesRepository clubActivitiesRepository) {
        this.athleteRepository = athleteRepository;
        this.clubActivitiesRepository = clubActivitiesRepository;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {


        // Lấy access token từ session
        String accessToken = (String) session.getAttribute("access_token");

        // Nếu access token không tồn tại, chuyển hướng người dùng về trang đăng nhập
        if (accessToken == null) {
            return "redirect:/login";
        }

        // Tạo HttpHeaders mới và thiết lập trường Authorization
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        // Tạo HttpEntity mới với headers đã tạo
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Tạo RestTemplate mới
        RestTemplate restTemplate = new RestTemplate();

        // Gửi yêu cầu GET đến API và lấy phản hồi
        ResponseEntity<Athlete> response = restTemplate.exchange(
                "https://www.strava.com/api/v3/athlete",
                HttpMethod.GET,
                entity,
                Athlete.class
        );

        Athlete athlete = response.getBody();

        // Kiểm tra xem Athlete đã tồn tại trong cơ sở dữ liệu hay chưa
        if (athleteRepository.existsByProfile(athlete.getProfile())) {
            // Nếu Athlete đã tồn tại, cập nhật thông tin cho Athlete đó
            Athlete existingAthlete = athleteRepository.findById(athlete.getId()).orElse(null);
            if (existingAthlete != null) {
                existingAthlete.updateWith(athlete);
                athleteRepository.save(existingAthlete);
            }
        } else {
            // Nếu Athlete chưa tồn tại, lưu Athlete mới
            athleteRepository.save(athlete);
        }

        // Lấy dữ liệu từ cơ sở dữ liệu
        Athlete athleteFromDb = athleteRepository.findById(athlete.getId()).orElse(null);

        // Thêm dữ liệu vào model
        model.addAttribute("athlete", athleteFromDb);

        // Thêm Athlete vào session
        session.setAttribute("athlete", response.getBody());

        // Thêm phản hồi vào model
        model.addAttribute("athlete", response.getBody());

        return "dashboard";
    }

}
