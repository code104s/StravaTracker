package com.code104s.StravaSortScore.controller;

import com.code104s.StravaSortScore.DAO.ActivityRepository;
import com.code104s.StravaSortScore.entity.Activity;
import com.code104s.StravaSortScore.entity.Athlete;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityController(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @GetMapping("/showFormCreate")
    public String showAddActivityForm(Model model, HttpSession session) {
        Athlete athlete = (Athlete) session.getAttribute("athlete");
        if (athlete == null) {
            // Handle the case where no athlete is in the session.
            // This could involve redirecting the user to a login page, for example.
            return "redirect:/login";
        }
        model.addAttribute("athlete", athlete);
        model.addAttribute("activity", new Activity());

        // Trả về tên của view
        return "add-activity";
    }

    // save activity
    @PostMapping("/save")
    public String createActivity(@ModelAttribute Activity activity, HttpSession session) {
        // Lấy access token từ session
        String accessToken = (String) session.getAttribute("access_token");

        // Nếu access token không tồn tại, chuyển hướng người dùng về trang đăng nhập
        if (accessToken == null) {
            return "redirect:/login";
        }

        // Lưu hoạt động vào cơ sở dữ liệu
        activityRepository.save(activity);

        // Tạo HttpHeaders mới và thiết lập trường Authorization
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        // Tạo HttpEntity mới với hoạt động và headers
        HttpEntity<Activity> entity = new HttpEntity<>(activity, headers);

        // Tạo RestTemplate mới
        RestTemplate restTemplate = new RestTemplate();

        // Gửi yêu cầu POST đến API và lấy phản hồi
        ResponseEntity<String> response = restTemplate.exchange(
                "https://www.strava.com/api/v3/activities",
                HttpMethod.POST,
                entity,
                String.class
        );

        // Kiểm tra mã trạng thái phản hồi và xử lý tương ứng
        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Data was successfully sent to the API");
        } else {
            System.out.println("Failed to send data to the API");
        }

        // Chuyển hướng người dùng về trang dashboard
        return "redirect:/dashboard";
    }
}