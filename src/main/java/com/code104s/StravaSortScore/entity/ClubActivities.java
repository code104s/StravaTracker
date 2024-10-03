package com.code104s.StravaSortScore.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="club_activities")
public class ClubActivities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "club_id")
    private long clubId;

    @Column(name="club_athelete_id")
    private long clubAthleteId;

    @Column(name="name")
    private String name;

    @Column(name = "distance")
    private float distance;

    @Column(name = "moving_time")
    private int moving_time;

    @Column(name = "elapsed_time")
    private int elapsed_time;

    @Column(name="total_elevation_gain")
    private float total_elevation_gain;

    @Column(name = "type")
    private String type;

    @Column(name = "sport_type")
    private String sport_type;

    @Column(name="workout_type")
    private int workout_type;

    @Column(name = "athlete_firstname")
    private String athleteFirstname;

    @Column(name = "athlete_lastname")
    private String athleteLastname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "athlete_id", referencedColumnName = "id")
    private Athlete athlete;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClubActivities that = (ClubActivities) o;
        return Float.compare(that.distance, distance) == 0 &&
                moving_time == that.moving_time &&
                elapsed_time == that.elapsed_time &&
                Float.compare(that.total_elevation_gain, total_elevation_gain) == 0 &&
                workout_type == that.workout_type &&
                Objects.equals(name, that.name) &&
                Objects.equals(type, that.type) &&
                Objects.equals(sport_type, that.sport_type) &&
                Objects.equals(athleteFirstname, that.athleteFirstname) &&
                Objects.equals(athleteLastname, that.athleteLastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance, moving_time, elapsed_time, total_elevation_gain, type, sport_type, workout_type, athleteFirstname, athleteLastname);
    }

    // constructor
    public ClubActivities() {
    }

    public ClubActivities(long clubId, long clubAthleteId, String name, float distance, int moving_time, int elapsed_time, float total_elevation_gain, String type, String sport_type, int workout_type, String athleteFirstname, String athleteLastname, Athlete athlete) {
        this.clubId = clubId;
        this.clubAthleteId = clubAthleteId;
        this.name = name;
        this.distance = distance;
        this.moving_time = moving_time;
        this.elapsed_time = elapsed_time;
        this.total_elevation_gain = total_elevation_gain;
        this.type = type;
        this.sport_type = sport_type;
        this.workout_type = workout_type;
        this.athleteFirstname = athleteFirstname;
        this.athleteLastname = athleteLastname;
        this.athlete = athlete;
    }

    public String getAthleteFirstname() {
        return athleteFirstname;
    }

    public void setAthleteFirstname(String athleteFirstname) {
        this.athleteFirstname = athleteFirstname;
    }

    public String getAthleteLastname() {
        return athleteLastname;
    }

    public void setAthleteLastname(String athleteLastname) {
        this.athleteLastname = athleteLastname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClubId() {
        return clubId;
    }

    public void setClubId(long clubId) {
        this.clubId = clubId;
    }

    public long getClubAthleteId() {
        return clubAthleteId;
    }

    public void setClubAthleteId(long clubAthleteId) {
        this.clubAthleteId = clubAthleteId;
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

    public float getTotal_elevation_gain() {
        return total_elevation_gain;
    }

    public void setTotal_elevation_gain(float total_elevation_gain) {
        this.total_elevation_gain = total_elevation_gain;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSport_type() {
        return sport_type;
    }

    public void setSport_type(String sport_type) {
        this.sport_type = sport_type;
    }

    public int getWorkout_type() {
        return workout_type;
    }

    public void setWorkout_type(int workout_type) {
        this.workout_type = workout_type;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    @Override
    public String toString() {
        return "ClubActivities{" +
                "id=" + id +
                ", clubId=" + clubId +
                ", clubAthleteId=" + clubAthleteId +
                ", name='" + name + '\'' +
                ", distance=" + distance +
                ", moving_time=" + moving_time +
                ", elapsed_time=" + elapsed_time +
                ", total_elevation_gain=" + total_elevation_gain +
                ", type='" + type + '\'' +
                ", sport_type='" + sport_type + '\'' +
                ", workout_type=" + workout_type +
                ", athleteFirstname='" + athleteFirstname + '\'' +
                ", athleteLastname='" + athleteLastname + '\'' +
                ", athlete=" + athlete +
                '}';
    }
}
