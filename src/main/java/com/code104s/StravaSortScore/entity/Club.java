package com.code104s.StravaSortScore.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "resource_state")
    private int resourceState;

    @Column(name = "name")
    private String name;

    @Column(name = "profile_medium")
    private String profileMedium;

    @Column(name = "cover_photo")
    private String coverPhoto;

    @Column(name = "cover_photo_small")
    private String coverPhotoSmall;

    @Column(name = "sport_type")
    private String sportType;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "private_club")
    private boolean privateClub;

    @Column(name = "member_count")
    private int memberCount;

    @Column(name = "featured")
    private boolean featured;

    @Column(name = "verified")
    private boolean verified;

    @Column(name = "url")
    private String url;

    // Constructor
    public Club() {
    }

    public Club(int resourceState, String name, String profileMedium, String coverPhoto, String coverPhotoSmall, String sportType, String city, String state, String country, boolean privateClub, int memberCount, boolean featured, boolean verified, String url) {
        this.resourceState = resourceState;
        this.name = name;
        this.profileMedium = profileMedium;
        this.coverPhoto = coverPhoto;
        this.coverPhotoSmall = coverPhotoSmall;
        this.sportType = sportType;
        this.city = city;
        this.state = state;
        this.country = country;
        this.privateClub = privateClub;
        this.memberCount = memberCount;
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

    public int getResourceState() {
        return resourceState;
    }

    public void setResourceState(int resourceState) {
        this.resourceState = resourceState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileMedium() {
        return profileMedium;
    }

    public void setProfileMedium(String profileMedium) {
        this.profileMedium = profileMedium;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getCoverPhotoSmall() {
        return coverPhotoSmall;
    }

    public void setCoverPhotoSmall(String coverPhotoSmall) {
        this.coverPhotoSmall = coverPhotoSmall;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
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

    public boolean isPrivateClub() {
        return privateClub;
    }

    public void setPrivateClub(boolean privateClub) {
        this.privateClub = privateClub;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
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

    @Override
    public String toString() {
        return "Club{" +
                "id=" + id +
                ", resourceState=" + resourceState +
                ", name='" + name + '\'' +
                ", profileMedium='" + profileMedium + '\'' +
                ", coverPhoto='" + coverPhoto + '\'' +
                ", coverPhotoSmall='" + coverPhotoSmall + '\'' +
                ", sportType='" + sportType + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", privateClub=" + privateClub +
                ", memberCount=" + memberCount +
                ", featured=" + featured +
                ", verified=" + verified +
                ", url='" + url + '\'' +
                '}';
    }
}