package com.code104s.StravaSortScore.DAO;

import com.code104s.StravaSortScore.entity.ClubActivities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ClubActivitiesRepository extends JpaRepository<ClubActivities, Long> {

    List<ClubActivities> findByClubId(long clubId);

    void deleteAllByClubId(long clubId);

    @Query("SELECT c FROM ClubActivities c WHERE c.athleteFirstname = :firstname AND c.athleteLastname = :lastname AND c.distance = :distance AND c.type = :type")
    List<ClubActivities> findDuplicateActivities(String firstname, String lastname, float distance, String type);
}

