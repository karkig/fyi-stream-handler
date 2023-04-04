package com.ps.attendance.repository;

import com.ps.attendance.dao.UserDailyAttendanceResult;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AttendanceRepository extends CrudRepository<UserDailyAttendanceResult, Integer> {

    @Query(value = "SELECT no_of_hours, date, user_id FROM user_attendance_result WHERE date = :date and user_id =:user_id", nativeQuery = true)
    public List<Object[]> findByUserIdAndDate(Date date, String user_id);

}
