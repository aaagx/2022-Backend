package com.example.concerto.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class WxUser {
    String openId;
    String skey;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date lastVisitTime;
    String sessionKey;
    String city;
    String province;
    String country;
    String avatarUrl;
    int gender;
    String nickname;

    public WxUser(String openId, String skey, Date createTime, Date lastVisitTime, String sessionKey, String city, String province, String country, String avatarUrl, int gender, String nickname) {
        this.openId = openId;
        this.skey = skey;
        this.createTime = createTime;
        this.lastVisitTime = lastVisitTime;
        this.sessionKey = sessionKey;
        this.city = city;
        this.province = province;
        this.country = country;
        this.avatarUrl = avatarUrl;
        this.gender = gender;
        this.nickname = nickname;
    }

    public WxUser() {
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastVisitTime() {
        return lastVisitTime;
    }

    public void setLastVisitTime(Date lastVisitTime) {
        this.lastVisitTime = lastVisitTime;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "WxUser{" +
                "openId='" + openId + '\'' +
                ", skey='" + skey + '\'' +
                ", createTime=" + createTime +
                ", lastVisitTime=" + lastVisitTime +
                ", sessionKey='" + sessionKey + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gender=" + gender +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
