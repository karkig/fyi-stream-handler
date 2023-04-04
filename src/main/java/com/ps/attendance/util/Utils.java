package com.ps.attendance.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

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

}
