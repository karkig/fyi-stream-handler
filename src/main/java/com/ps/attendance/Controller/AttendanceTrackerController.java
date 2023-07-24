package com.ps.attendance.Controller;

import com.ps.attendance.service.AttendanceTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api")
public class AttendanceTrackerController {

    @Autowired
    AttendanceTrackerService attendanceTrackerService;

    @GetMapping(value = "/user-attendance")
    public ResponseEntity<String> getTotalHours(@RequestParam("userId") String userId) {
        return ResponseEntity.ok()
                .body(attendanceTrackerService.calculateTotalHours(userId));


    }
}
