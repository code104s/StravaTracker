package com.code104s.StravaSortScore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Table(name="activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "distance")
    private float distance;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "start_date_local")
    private LocalDateTime startDateLocal;

    @Column(name = "timezone")
    private String timezone;

    @Column(name = "achievement_count")
    private int achievementCount;

    @Column(name = "kudos_count")
    private int kudosCount;

    @Column(name = "average_speed")
    private float averageSpeed;

    @Column(name = "max_speed")
    private float maxSpeed;

    @Column(name = "has_heartrate")
    private boolean hasHeartrate;

    @Column(name = "average_heartrate")
    private float averageHeartrate;

    @Column(name = "max_heartrate")
    private int maxHeartrate;

    @Column(name = "elev_high")
    private float elevHigh;

    @Column(name = "elev_low")
    private float elevLow;

    // Constructor
    public Activity() {
    }

    public Activity(String name, float distance, LocalDateTime startDate, LocalDateTime startDateLocal, String timezone, int achievementCount, int kudosCount, float averageSpeed, float maxSpeed, boolean hasHeartrate, float averageHeartrate, int maxHeartrate, float elevHigh, float elevLow) {
        this.name = name;
        this.distance = distance;
        this.startDate = startDate;
        this.startDateLocal = startDateLocal;
        this.timezone = timezone;
        this.achievementCount = achievementCount;
        this.kudosCount = kudosCount;
        this.averageSpeed = averageSpeed;
        this.maxSpeed = maxSpeed;
        this.hasHeartrate = hasHeartrate;
        this.averageHeartrate = averageHeartrate;
        this.maxHeartrate = maxHeartrate;
        this.elevHigh = elevHigh;
        this.elevLow = elevLow;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getStartDateLocal() {
        return startDateLocal;
    }

    public void setStartDateLocal(LocalDateTime startDateLocal) {
        this.startDateLocal = startDateLocal;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getAchievementCount() {
        return achievementCount;
    }

    public void setAchievementCount(int achievementCount) {
        this.achievementCount = achievementCount;
    }

    public int getKudosCount() {
        return kudosCount;
    }

    public void setKudosCount(int kudosCount) {
        this.kudosCount = kudosCount;
    }

    public float getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(float averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean isHasHeartrate() {
        return hasHeartrate;
    }

    public void setHasHeartrate(boolean hasHeartrate) {
        this.hasHeartrate = hasHeartrate;
    }

    public float getAverageHeartrate() {
        return averageHeartrate;
    }

    public void setAverageHeartrate(float averageHeartrate) {
        this.averageHeartrate = averageHeartrate;
    }

    public int getMaxHeartrate() {
        return maxHeartrate;
    }

    public void setMaxHeartrate(int maxHeartrate) {
        this.maxHeartrate = maxHeartrate;
    }

    public float getElevHigh() {
        return elevHigh;
    }

    public void setElevHigh(float elevHigh) {
        this.elevHigh = elevHigh;
    }

    public float getElevLow() {
        return elevLow;
    }

    public void setElevLow(float elevLow) {
        this.elevLow = elevLow;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", distance=" + distance +
                ", startDate=" + startDate +
                ", startDateLocal=" + startDateLocal +
                ", timezone='" + timezone + '\'' +
                ", achievementCount=" + achievementCount +
                ", kudosCount=" + kudosCount +
                ", averageSpeed=" + averageSpeed +
                ", maxSpeed=" + maxSpeed +
                ", hasHeartrate=" + hasHeartrate +
                ", averageHeartrate=" + averageHeartrate +
                ", maxHeartrate=" + maxHeartrate +
                ", elevHigh=" + elevHigh +
                ", elevLow=" + elevLow +
                '}';
    }
}