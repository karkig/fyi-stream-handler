package com.ps.attendance.dao;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


public class UserDailyAttendanceResult {

    private Integer id;

    private String userId;

    private Integer noOfHours;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getTime() {
        return noOfHours;
    }

    public void setTime(Integer time) {
        this.noOfHours = time;
    }

}
