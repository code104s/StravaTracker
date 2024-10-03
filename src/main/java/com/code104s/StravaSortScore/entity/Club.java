package com.code104s.StravaSortScore.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table(name="club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "api_id")
    private long apiId;

    @Column(name = "resource_state")
    private int resource_state;

    @Column(name = "name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name = "profile_medium")
    private String profile_medium;

    @Column(name = "cover_photo")
    private String cover_photo;

    @Column(name = "cover_photo_small")
    private String cover_photo_small;

    @ElementCollection
    @CollectionTable(name = "activity_types", joinColumns = @JoinColumn(name = "club_id"))
    @Column(name = "activity_type")
    private List<String> activityTypes;

    @Column(name = "sport_type")
    private String sport_type;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "private_club")
    private boolean private_club;

    @Column(name = "member_count")
    private int member_count;

    @Column(name = "featured")
    private boolean featured;

    @Column(name = "verified")
    private boolean verified;

    @Column(name = "url")
    private String url;


    // Constructor
    public Club() {
    }

    public Club(long apiId, int resource_state, String name, String description, String profile_medium, String cover_photo, String cover_photo_small, List<String> activityTypes, String sport_type, String city, String state, String country, boolean private_club, int member_count, boolean featured, boolean verified, String url) {
        this.apiId = apiId;
        this.resource_state = resource_state;
        this.name = name;
        this.description = description;
        this.profile_medium = profile_medium;
        this.cover_photo = cover_photo;
        this.cover_photo_small = cover_photo_small;
        this.activityTypes = activityTypes;
        this.sport_type = sport_type;
        this.city = city;
        this.state = state;
        this.country = country;
        this.private_club = private_club;
        this.member_count = member_count;
        this.featured = featured;
        this.verified = verified;
        this.url = url;
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



    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getApiId() {
        return apiId;
    }

    public void setApiId(long apiId) {
        this.apiId = apiId;
    }

    public int getMember_count() {
        return member_count;
    }

    public void setMember_count(int member_count) {
        this.member_count = member_count;
    }

    public boolean isPrivate_club() {
        return private_club;
    }

    public void setPrivate_club(boolean private_club) {
        this.private_club = private_club;
    }

    public String getSport_type() {
        return sport_type;
    }

    public void setSport_type(String sport_type) {
        this.sport_type = sport_type;
    }

    public List<String> getActivityTypes() {
        return activityTypes;
    }

    public void setActivityTypes(List<String> activityTypes) {
        this.activityTypes = activityTypes;
    }

    public String getCover_photo_small() {
        return cover_photo_small;
    }

    public void setCover_photo_small(String cover_photo_small) {
        this.cover_photo_small = cover_photo_small;
    }

    public String getCover_photo() {
        return cover_photo;
    }

    public void setCover_photo(String cover_photo) {
        this.cover_photo = cover_photo;
    }

    public String getProfile_medium() {
        return profile_medium;
    }

    public void setProfile_medium(String profile_medium) {
        this.profile_medium = profile_medium;
    }

    public int getResource_state() {
        return resource_state;
    }

    public void setResource_state(int resource_state) {
        this.resource_state = resource_state;
    }

    @Override
    public String toString() {
        return "Club{" +
                "id=" + id +
                ", apiId=" + apiId +
                ", resource_state=" + resource_state +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", profile_medium='" + profile_medium + '\'' +
                ", cover_photo='" + cover_photo + '\'' +
                ", cover_photo_small='" + cover_photo_small + '\'' +
                ", activityTypes=" + activityTypes +
                ", sport_type='" + sport_type + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", private_club=" + private_club +
                ", member_count=" + member_count +
                ", featured=" + featured +
                ", verified=" + verified +
                ", url='" + url + '\'' +
                '}';
    }
}