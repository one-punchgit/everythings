package com.zb.thing.basic.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeUtil {

    public static void main(String[] args) {
        String format = String.format("ab%s%sab", "ca", "aaa");
        System.out.println(format);
        String s = convertTimestampToString(1703574634511l, "yyyy-MM-dd");
        String s1 = convertTimestampToString(1703574634511l, "yyyy-MM-dd HH:mm:ss");
        System.out.println(s);
        System.out.println(s1);
    }

    public static String convertTimestampToString(long timestamp , String format) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.of("Asia/Shanghai"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return dateTime.format(formatter);
    }
}
