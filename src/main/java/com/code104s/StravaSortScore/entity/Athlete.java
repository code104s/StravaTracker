package com.code104s.StravaSortScore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="athlete")
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;


    @Column(name = "resource_state")
    private int resource_state;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "sex")
    private String sex;

    @Column(name = "premium")
    private boolean premium;

    @Column(name = "summit")
    private boolean summit;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "updated_at")
    private String updated_at;

    @Column(name = "badge_type_id")
    private int badge_type_id;

    @Column(name = "profile_medium")
    private String profile_medium;

    @Column(name = "profile")
    private String profile;



    public void updateWith(Athlete athlete) {
        setUsername(athlete.getUsername());
        setResource_state(athlete.getResource_state());
        setFirstname(athlete.getFirstname());
        setLastname(athlete.getLastname());
        setCity(athlete.getCity());
        setState(athlete.getState());
        setCountry(athlete.getCountry());
    }


    // Constructor
    public Athlete() {
    }

    public Athlete(String username, int resource_state, String firstname, String lastname, String city, String state, String country, String sex, boolean premium, boolean summit, String created_at, String updated_at, int badge_type_id, String profile_medium, String profile) {
        this.username = username;
        this.resource_state = resource_state;
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
        this.state = state;
        this.country = country;
        this.sex = sex;
        this.premium = premium;
        this.summit = summit;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.badge_type_id = badge_type_id;
        this.profile_medium = profile_medium;
        this.profile = profile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getResource_state() {
        return resource_state;
    }

    public void setResource_state(int resource_state) {
        this.resource_state = resource_state;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public boolean isSummit() {
        return summit;
    }

    public void setSummit(boolean summit) {
        this.summit = summit;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getBadge_type_id() {
        return badge_type_id;
    }

    public void setBadge_type_id(int badge_type_id) {
        this.badge_type_id = badge_type_id;
    }

    public String getProfile_medium() {
        return profile_medium;
    }

    public void setProfile_medium(String profile_medium) {
        this.profile_medium = profile_medium;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", resource_state=" + resource_state +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", sex='" + sex + '\'' +
                ", premium=" + premium +
                ", summit=" + summit +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", badge_type_id=" + badge_type_id +
                ", profile_medium='" + profile_medium + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }
}