package com.ps.attendance.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ps.attendance.dao.UserDailyAttendanceStatus;
import com.ps.attendance.dao.UserDailyAttendanceStatus1;
import com.ps.attendance.repository.AttendanceRepository;
import com.ps.attendance.service.AttendanceTrackerService;
import com.ps.attendance.service.KafkaProducer;
import com.ps.attendance.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Service
public class AttendanceTrackerServiceImpl implements AttendanceTrackerService {

    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    KafkaProducer kafkaProducer;

    @Override
    public boolean cardSwap(UserDailyAttendanceStatus status) {
        UserDailyAttendanceStatus save = attendanceRepository.save(status);
        return save.getId() != null;
    }

    @Override
    public boolean calculateTotalHours() {

        Iterable<Object[]> userDailyAttendanceStatuses = attendanceRepository.calculateTotalHours(Utils.getCurrentDate());

        userDailyAttendanceStatuses.forEach(e -> {
            Date outTime = (Date) e[0];
            Date inTime = (Date) e[1];
            Date date = (Date) e[2];
            String userId = (String) e[3];

            String difference = Utils.calculateTimeDifference(Utils.convertDateToLocalDateTime(outTime), Utils.convertDateToLocalDateTime(inTime));
            sendMessage(difference);

        });
        return true;
    }


    public boolean sendMessage(String message) {
        kafkaProducer.sendMessageToTopic(message);
        return true;
    }

}
