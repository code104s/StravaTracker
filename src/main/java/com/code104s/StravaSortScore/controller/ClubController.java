package com.code104s.StravaSortScore.controller;

import com.code104s.StravaSortScore.DAO.ClubActivitiesRepository;
import com.code104s.StravaSortScore.entity.Athlete;
import com.code104s.StravaSortScore.entity.Club;
import com.code104s.StravaSortScore.entity.ClubActivities;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/club")
public class ClubController {

    @Autowired
    private final ClubActivitiesRepository clubActivitiesRepository;

    @Autowired
    public ClubController(ClubActivitiesRepository clubActivitiesRepository) {
        this.clubActivitiesRepository = clubActivitiesRepository;
    }

    // Danh sach club cua athelete
    @GetMapping("/list")
    public String listClub() {
        return "list-club";
    }

    @Transactional
    @GetMapping("activities")
    public String showActivitiesClub(@RequestParam("clubId") Long clubId,
                                     // Thêm tham số startDate và endDate vào phương thức showActivitiesClub(
                                     @RequestParam(value = "start", required = false) String start_date,
                                     @RequestParam(value = "end", required = false) String end_date,
                                     HttpSession session,
                                     Model model) {

        // neu co du lieu trong bang clubActivities thi xoa het
        if (clubActivitiesRepository.findByClubId(clubId).size() > 0) {
            clubActivitiesRepository.deleteAllByClubId(clubId);
        }

        // Lay access token tu session
        String accessToken = (String) session.getAttribute("access_token");

        // Lay profile tu session
        String profile = (String) session.getAttribute("profile");

        // Kiem tra xem access token co ton tai khong
        if (accessToken == null) {
            return "redirect:/login"; // tra ve trang login
        }

        // lay athelete da authenticated tu session
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


        // lay thong tin club tu api
        ResponseEntity<Club> clubResponse = restTemplate.exchange(
                "https://www.strava.com/api/v3/clubs/" + clubId,
                HttpMethod.GET,
                entity,
                Club.class
        );

        Club club = clubResponse.getBody();

        if (club == null) {
            return "redirect:/club/list";
        }


        model.addAttribute("club", club);

        // Kiem tra xem ngay bat dau va ket thuc co ton tai khong
        if (start_date != null && end_date != null) {

            // Convert the start_date and end_date to epoch time
            long afterEpochDayA = LocalDateTime.parse(start_date + "T00:00:00", DateTimeFormatter.ISO_DATE_TIME)
                    .toEpochSecond(ZoneOffset.UTC);
            long afterEpochDayB = LocalDateTime.parse(end_date + "T23:59:59", DateTimeFormatter.ISO_DATE_TIME)
                    .toEpochSecond(ZoneOffset.UTC);

            // Initialize a list to store all activities
            List<ClubActivities> allActivitiesAfterDayA = new ArrayList<>();
            List<ClubActivities> allActivitiesAfterDayB = new ArrayList<>();

            // Initialize the page number
            int page = 1;

            // The maximum number of items per page
            int per_page = 200;

            // Get the activities after day A
            ResponseEntity<ClubActivities[]> responseAfterDayA;
            do {
                responseAfterDayA = restTemplate.exchange(
                        "https://www.strava.com/api/v3/clubs/" + clubId + "/activities?after=" + afterEpochDayA + "&page=" + page + "&per_page=" + per_page,
                        HttpMethod.GET,
                        entity,
                        ClubActivities[].class
                );
                ClubActivities[] activitiesAfterDayA = responseAfterDayA.getBody();
                if (activitiesAfterDayA != null) {

                    // Set clubId for each activity
                    for (ClubActivities activity : activitiesAfterDayA) {
                        activity.setClubId(clubId);
                    }

                    allActivitiesAfterDayA.addAll(Arrays.asList(activitiesAfterDayA));
                }
                page++;

                // Add a delay between API requests
                try {
                    Thread.sleep(3000); // Wait for 3 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } while (responseAfterDayA.getBody() != null && responseAfterDayA.getBody().length == per_page);

            // Reset the page number for the next API call
            page = 1;

            // Get the activities after day B
            ResponseEntity<ClubActivities[]> responseAfterDayB;
            do {
                responseAfterDayB = restTemplate.exchange(
                        "https://www.strava.com/api/v3/clubs/" + clubId + "/activities?after=" + afterEpochDayB + "&page=" + page + "&per_page=" + per_page,
                        HttpMethod.GET,
                        entity,
                        ClubActivities[].class
                );
                ClubActivities[] activitiesAfterDayB = responseAfterDayB.getBody();
                if (activitiesAfterDayB != null) {
                    // Set clubId for each activity
                    for (ClubActivities activity : activitiesAfterDayB) {
                        activity.setClubId(clubId);
                    }

                    allActivitiesAfterDayB.addAll(Arrays.asList(activitiesAfterDayB));
                }
                page++;

                // Add a delay between API requests
                try {
                    Thread.sleep(3000); // Wait for 3 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } while (responseAfterDayB.getBody() != null && responseAfterDayB.getBody().length == per_page);

            // Save all activities after day A and B to the database
            clubActivitiesRepository.saveAll(allActivitiesAfterDayA);
            clubActivitiesRepository.saveAll(allActivitiesAfterDayB);

            // Initialize a list to store the activities between the dates
            List<ClubActivities> activitiesBetweenDates = new ArrayList<>();

            // Get all activities from the database
            List<ClubActivities> allActivities = clubActivitiesRepository.findAll();

            for (ClubActivities activity : allActivities) {
                // Check if the activity is after day A and not after day B
                if (allActivitiesAfterDayA.contains(activity) && !allActivitiesAfterDayB.contains(activity)) {
                    activitiesBetweenDates.add(activity);
                }
            }

            // save activities by club id
            clubActivitiesRepository.saveAll(activitiesBetweenDates);

            // Add the activities to the model
            model.addAttribute("clubActivities", activitiesBetweenDates);


        }
        return "activities-club";
    }
    @Transactional
    @GetMapping("/clearActivities")
    public String clearActivities(@RequestParam("clubId") Long clubId) {

        clubActivitiesRepository.deleteAllByClubId(clubId);

        return "redirect:/club/activities?clubId=" + clubId;
    }
}
