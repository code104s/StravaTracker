package com.code104s.StravaSortScore.DAO;

import com.code104s.StravaSortScore.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {
}
