package com.code104s.StravaSortScore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name="activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "api_id")
    private long apiId;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private ActivityType type;

    public enum ActivityType{
        AlpineSki, BackcountrySki, Canoeing, Crossfit, EBikeRide, Elliptical, Golf, Handcycle, Hike, IceSkate, InlineSkate, Kayaking, Kitesurf, NordicSki, Ride, RockClimbing, RollerSki, Rowing, Run, Sail, Skateboard, Snowboard, Snowshoe, Soccer, StairStepper, StandUpPaddling, Surfing, Swim, Velomobile, VirtualRide, VirtualRun, Walk, WeightTraining, Wheelchair, Windsurf, Workout, Yoga
    }

    @Column(name = "sport_type")
    private SportType sport_type;

    public enum SportType{
        AlpineSki, BackcountrySki, Badminton, Canoeing, Crossfit, EBikeRide, Elliptical, EMountainBikeRide, Golf, GravelRide, Handcycle, HighIntensityIntervalTraining, Hike, IceSkate, InlineSkate, Kayaking, Kitesurf, MountainBikeRide, NordicSki, Pickleball, Pilates, Racquetball, Ride, RockClimbing, RollerSki, Rowing, Run, Sail, Skateboard, Snowboard, Snowshoe, Soccer, Squash, StairStepper, StandUpPaddling, Surfing, Swim, TableTennis, Tennis, TrailRun, Velomobile, VirtualRide, VirtualRow, VirtualRun, Walk, WeightTraining, Wheelchair, Windsurf, Workout, Yoga
    }

    @Column(name = "distance")
    private float distance;

    @Column(name = "start_date")
    private LocalDateTime start_date;

    @Column(name = "start_date_local")
    private LocalDateTime start_date_local;

    @Column(name="moving_time")
    private int moving_time;

    @Column(name="elapsed_time")
    private int elapsed_time;

    @Column(name="description")
    private String description;

    @Column(name="trainer")
    private Boolean trainer;

    @Column(name="commute")
    private Boolean commute;

    @Column(name = "timezone")
    private String timezone;

    @Column(name = "achievement_count")
    private int achievement_count;


    // Constructor
    public Activity() {
    }

    public Activity(long apiId, String name, ActivityType type, SportType sport_type, float distance, LocalDateTime start_date, LocalDateTime start_date_local, int moving_time, int elapsed_time, String description, Boolean trainer, Boolean commute, String timezone, int achievement_count) {
        this.apiId = apiId;
        this.name = name;
        this.type = type;
        this.sport_type = sport_type;
        this.distance = distance;
        this.start_date = start_date;
        this.start_date_local = start_date_local;
        this.moving_time = moving_time;
        this.elapsed_time = elapsed_time;
        this.description = description;
        this.trainer = trainer;
        this.commute = commute;
        this.timezone = timezone;
        this.achievement_count = achievement_count;
    }



    public long getApiId() {
        return apiId;
    }

    public void setApiId(long apiId) {
        this.apiId = apiId;
    }


    public ActivityType getType() {
        return type;
    }

    public void setType(ActivityType type) {
        this.type = type;
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



    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getTrainer() {
        return trainer;
    }

    public void setTrainer(Boolean trainer) {
        this.trainer = trainer;
    }

    public Boolean getCommute() {
        return commute;
    }

    public void setCommute(Boolean commute) {
        this.commute = commute;
    }

    public SportType getSport_type() {
        return sport_type;
    }

    public void setSport_type(SportType sport_type) {
        this.sport_type = sport_type;
    }

    public LocalDateTime getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDateTime start_date) {
        this.start_date = start_date;
    }

    public LocalDateTime getStart_date_local() {
        return start_date_local;
    }

    public void setStart_date_local(LocalDateTime start_date_local) {
        this.start_date_local = start_date_local;
    }

    public int getMoving_time() {
        return moving_time;
    }

    public void setMoving_time(int moving_time) {
        this.moving_time = moving_time;
    }

    public int getElapsed_time() {
        return elapsed_time;
    }

    public void setElapsed_time(int elapsed_time) {
        this.elapsed_time = elapsed_time;
    }

    public int getAchievement_count() {
        return achievement_count;
    }

    public void setAchievement_count(int achievement_count) {
        this.achievement_count = achievement_count;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", apiId=" + apiId +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", sport_type=" + sport_type +
                ", distance=" + distance +
                ", start_date=" + start_date +
                ", start_date_local=" + start_date_local +
                ", moving_time=" + moving_time +
                ", elapsed_time=" + elapsed_time +
                ", description='" + description + '\'' +
                ", trainer=" + trainer +
                ", commute=" + commute +
                ", timezone='" + timezone + '\'' +
                ", achievement_count=" + achievement_count +
                '}';
    }
}