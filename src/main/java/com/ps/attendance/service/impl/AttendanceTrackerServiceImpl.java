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

        List<Object[]> status = attendanceRepository.findByUserIdAndDate(Utils.getCurrentDate(), userId);
        for (Object[] row : status) {
            if ((Integer) row[0] < 4) {
                return "Absent";
            } else if ((Integer) row[0] > 4 && (Integer) row[0] < 8) {
                return "Half-Day";
            }
        }
        return "Present";
    }


}
