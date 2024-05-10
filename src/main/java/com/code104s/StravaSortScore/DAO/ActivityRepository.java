package com.code104s.StravaSortScore.DAO;

import com.code104s.StravaSortScore.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
