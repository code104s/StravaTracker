package com.code104s.StravaSortScore.controller;

import com.code104s.StravaSortScore.DAO.ActivityRepository;
import com.code104s.StravaSortScore.DAO.ClubRepository;
import com.code104s.StravaSortScore.entity.Activity;
import com.code104s.StravaSortScore.entity.Athlete;
import com.code104s.StravaSortScore.entity.Club;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/athlete")
public class AthleteController {

    @Autowired
    private final ActivityRepository activityRepository;
    private final ClubRepository clubRepository;

    @Autowired
    public AthleteController(ActivityRepository activityRepository, ClubRepository clubRepository) {
        this.activityRepository = activityRepository;
        this.clubRepository = clubRepository;
    }

    @GetMapping("/activities")
    public String activity(Model model, HttpSession session) {



        // Lấy access token từ session
        String accessToken = (String) session.getAttribute("access_token");

        // Lấy profile từ session
        String profile = (String) session.getAttribute("profile");

        // Nếu access token không tồn tại, chuyển hướng người dùng về trang đăng nhập
        if (accessToken == null) {
            return "redirect:/login";
        }

        // Lay doi tuong Athelete tu session
        Athlete athlete = (Athlete) session.getAttribute("athlete");

        // Them doi tuong Athlete vao model
        model.addAttribute("athlete", athlete);

        // Tạo HttpHeaders mới và thiết lập trường Authorization
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        // Tạo HttpEntity mới với headers đã tạo
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(headers);

        // Tạo RestTemplate mới
        RestTemplate restTemplate = new RestTemplate();

        // Gửi yêu cầu GET đến API và lấy phản hồi
        ResponseEntity<Activity[]> response = restTemplate.exchange(
                "https://www.strava.com/api/v3/athlete/activities?access_token=" + accessToken,
                HttpMethod.GET,
                entity,
                Activity[].class
        );

        // Lưu Activity vào cơ sở dữ liệu
        for (Activity activity : response.getBody()) {

            // cập nhập apiId cho activity
            activity.setApiId(Long.valueOf(activity.getId()));

            // Kiểm tra xem Activity đã tồn tại trong cơ sở dữ liệu hay chưa
            if (!activityRepository.existsByApiId(activity.getApiId())) {
                // Nếu Activity chưa tồn tại, lưu Activity mới
                activityRepository.save(activity);
            }
        }

        // Lấy Activity từ cơ sở dữ liệu
        List<Activity> activities = activityRepository.findAll();

        // Thêm Activity vào model
        model.addAttribute("activities", activities);

        // Trả về view activity
        return "activity";
    }

    // danh sach club cua athlete
    @GetMapping("/clubs")
    public String listClub(Model model, HttpSession session) {
        // Lấy profile từ session
        String profile = (String) session.getAttribute("profile");

        // Get the access token from the session
        String accessToken = (String) session.getAttribute("access_token");

        // If the access token does not exist, redirect the user to the login page
        if (accessToken == null) {
            return "redirect:/login";
        }

        // Lay doi tuong Athelete tu session
        Athlete athlete = (Athlete) session.getAttribute("athlete");

        // Them doi tuong Athlete vao model
        model.addAttribute("athlete", athlete);

        Map<String, String> params = new HashMap<>();

        // Create new HttpHeaders and set the Authorization field
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        // Create a new HttpEntity with the headers
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(params, headers);

        // Create a new RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Send a GET request to the API and get the response
        ResponseEntity<Club[]> response = restTemplate.exchange(
                "https://www.strava.com/api/v3/athlete/clubs?per_page=30",
                HttpMethod.GET,
                entity,
                Club[].class
        );
        System.out.println("Clubs: " + Arrays.toString(response.getBody()));

        // Lưu clubs vào cơ sở dữ liệu
        for (Club club : response.getBody()) {
            // Kiểm tra xem Club đã tồn tại trong cơ sở dữ liệu hay chưa
            if (!clubRepository.existsByApiId(club.getId())) {

                // cập nhập apiId cho club
                club.setApiId(Long.valueOf(club.getId()));

                // cap nhap member_count cho club
                club.setMember_count(club.getMember_count());

                // Nếu Club chưa tồn tại, lưu Club mới
                clubRepository.save(club);
            }
        }

        // lay danh sach club tu co so du lieu
        List<Club> clubs = clubRepository.findAll();


        // Add the clubs to the model
        model.addAttribute("clubs", clubs);


        // Return the name of the view
        return "list-club";
    }

}
