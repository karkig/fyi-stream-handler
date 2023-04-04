package com.ps.attendance.repository;

import com.ps.attendance.dao.UserDailyAttendanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AttendanceRepository extends CrudRepository<UserDailyAttendanceStatus, Integer> {

    //select max(out_time) , min(in_time) ,date ,user_id from user_attendance where date='2023-04-03' group by user_id

    @Query(value = "SELECT MAX(out_time) as outTime, MIN(in_time) as inTime, date, user_id FROM user_attendance WHERE date = :date group by user_id", nativeQuery = true)
    public Iterable<Object[]> calculateTotalHours(Date date);

}
