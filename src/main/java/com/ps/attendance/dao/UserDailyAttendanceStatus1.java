package com.ps.attendance.dao;

import javax.persistence.*;
import java.util.Date;


public class UserDailyAttendanceStatus1 {
    public UserDailyAttendanceStatus1(String userId,String date, String outTime, String inTime) {
        this.userId = userId;
        this.inTime = inTime;
        this.outTime = outTime;
        this.date = date;
    }

    private String userId;


    private String inTime;

    private String outTime;

    private String date;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
