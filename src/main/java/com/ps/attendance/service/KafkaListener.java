package com.ps.attendance.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ps.attendance.dao.UserDailyAttendanceResult;
import com.ps.attendance.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaListener {
    @Autowired
    AttendanceRepository attendanceRepository;
    @Autowired
    ObjectMapper mapper;

    @org.springframework.kafka.annotation.KafkaListener(topics = "attendance", groupId = "attendance-group")
    public void listenToCodeDecodeKafkaTopic(String messageReceived) {
        System.out.println("Message received is " + messageReceived);
        try {
            UserDailyAttendanceResult result = mapper.readValue(messageReceived, UserDailyAttendanceResult.class);
            attendanceRepository.save(result);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
