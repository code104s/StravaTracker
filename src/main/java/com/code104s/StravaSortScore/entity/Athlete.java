package com.code104s.StravaSortScore.entity;

import jakarta.persistence.*;
import lombok.Data;

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
    private int resourceState;

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
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @Column(name = "badge_type_id")
    private int badgeTypeId;

    @Column(name = "profile_medium")
    private String profileMedium;

    @Column(name = "profile")
    private String profile;

    // Constructor
    public Athlete() {
    }

    public Athlete(String username, int resourceState, String firstname, String lastname, String city, String state, String country, String sex, boolean premium, boolean summit, String createdAt, String updatedAt, int badgeTypeId, String profileMedium, String profile) {
        this.username = username;
        this.resourceState = resourceState;
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
        this.state = state;
        this.country = country;
        this.sex = sex;
        this.premium = premium;
        this.summit = summit;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.badgeTypeId = badgeTypeId;
        this.profileMedium = profileMedium;
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

    public int getResourceState() {
        return resourceState;
    }

    public void setResourceState(int resourceState) {
        this.resourceState = resourceState;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getBadgeTypeId() {
        return badgeTypeId;
    }

    public void setBadgeTypeId(int badgeTypeId) {
        this.badgeTypeId = badgeTypeId;
    }

    public String getProfileMedium() {
        return profileMedium;
    }

    public void setProfileMedium(String profileMedium) {
        this.profileMedium = profileMedium;
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
                ", resourceState=" + resourceState +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", sex='" + sex + '\'' +
                ", premium=" + premium +
                ", summit=" + summit +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", badgeTypeId=" + badgeTypeId +
                ", profileMedium='" + profileMedium + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }
}