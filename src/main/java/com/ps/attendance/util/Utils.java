package com.ps.attendance.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Utils {
    public static Date getCurrentDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Date todayWithZeroTime = null;
        try {
            todayWithZeroTime = dateFormat.parse(dateFormat.format(date));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return todayWithZeroTime;
    }

    public static Date getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        Date todayWithZeroTime = null;
        try {
            todayWithZeroTime = dateFormat.parse(dateFormat.format(date));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return todayWithZeroTime;
    }

    public static String calculateTimeDifference(LocalDateTime start, LocalDateTime end) {
        Duration duration = Duration.between(start, end);

        long seconds = duration.getSeconds(); // Total seconds between the two dates
        long absSeconds = Math.abs(seconds);
        long nanos = duration.getNano(); // Nanoseconds between the two dates

        long hours = absSeconds / 3600; // Total hours between the two dates
        long minutes = (absSeconds % 3600) / 60; // Total minutes between the two dates
        long secondRemainder = absSeconds % 60; // Total seconds remaining after calculating hours and minutes

        return String.format("%d:%02d:%02d.%09d", hours, minutes, secondRemainder, nanos);
    }


    public static LocalDateTime convertDateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }
}
