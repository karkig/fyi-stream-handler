package com.ps.attendance.service.impl;

import com.ps.attendance.repository.AttendanceRepository;
import com.ps.attendance.service.AttendanceTrackerService;
import com.ps.attendance.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceTrackerServiceImpl implements AttendanceTrackerService {

    @Autowired
    AttendanceRepository attendanceRepository;

    @Override
    public String calculateTotalHours(String userId) {


        return "Present";
    }


}
