package com.ps.attendance.service;

import com.ps.attendance.dao.UserDailyAttendanceStatus;
import com.ps.attendance.dto.CardSwapRequest;

public interface AttendanceTrackerService {
    public boolean cardSwap(UserDailyAttendanceStatus request);

    public boolean calculateTotalHours();
}
