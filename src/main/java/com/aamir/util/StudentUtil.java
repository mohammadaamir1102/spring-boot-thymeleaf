package com.aamir.util;

import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class StudentUtil {

    public static Date getTenMinutesFutureTimeOfCurrentTime() {
        Date currentDate = new Date();
        Calendar calender = Calendar.getInstance();
        calender.setTime(currentDate);
        calender.add(Calendar.MINUTE, 10);
        return calender.getTime();
    }

    public static Boolean convertToBoolean(String input){
        String updateInput = input.toLowerCase().trim();
        return "true".equalsIgnoreCase(updateInput);

    }

}
