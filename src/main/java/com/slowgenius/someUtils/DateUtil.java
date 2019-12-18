package com.slowgenius.someUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

/**
 * @author slowgenius
 * @date 2019/12/18 13:32
 * @description
 */
public class DateUtil {

    //相差天数
    public static long dateBetween(long startTime, long endTime,ChronoUnit unit) {
        LocalDate start = LocalDateTime.ofEpochSecond(startTime, 0, ZoneOffset.ofHours(8)).toLocalDate();
        LocalDate end = LocalDateTime.ofEpochSecond(endTime, 0, ZoneOffset.ofHours(9)).toLocalDate();
        return start.until(end, unit);
    }

    public static long between(LocalDate start,LocalDate end,ChronoUnit unit) {
        return start.until(end, unit);
    }


    public static void main(String[] args) {
        long startTime = 10000L;
        LocalDateTime start = LocalDateTime.ofEpochSecond(startTime, 1, ZoneOffset.ofHours(8));
        System.out.println(start.toEpochSecond(ZoneOffset.ofHours(8)));
        System.out.println(start);
    }
}
