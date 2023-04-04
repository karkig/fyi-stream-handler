package com.ps.attendance.dto;

import java.util.Date;

public class CardSwapRequest {
    private Date swapIn;
    private Date swapOut;
    private String  userId;

    public Date getSwapIn() {
        return swapIn;
    }

    public void setSwapIn(Date swapIn) {
        this.swapIn = swapIn;
    }

    public Date getSwapOut() {
        return swapOut;
    }

    public void setSwapOut(Date swapOut) {
        this.swapOut = swapOut;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String id) {
        this.userId = id;
    }
}
