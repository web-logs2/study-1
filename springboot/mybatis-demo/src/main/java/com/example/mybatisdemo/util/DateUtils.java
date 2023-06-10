package com.example.mybatisdemo.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author 乐乡
 * @since 2023/6/6  14:19
 */
public class DateUtils {
    public static final DateTimeFormatter DEFAULT_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            .withZone(ZoneId.systemDefault());

    /**
     * 13位时间戳格式化时间字符串
     */
    public static String format(String thirteenBitTime, DateTimeFormatter dateTimeFormatter) {
        Instant instant = Instant.ofEpochMilli(Long.parseLong(thirteenBitTime));
        return dateTimeFormatter.format(instant);
    }

    public static String format(String thirteenBitTime) {
        return format(thirteenBitTime, DEFAULT_DATE_TIME_FORMATTER);
    }

    /**
     * Date对象转LocalDateTime对象
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }

    /**
     * localDateTime对象转Date对象
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        ZonedDateTime zdt = localDateTime.atZone(ZoneId.systemDefault());
        return Date.from(zdt.toInstant());
    }

    public static void main(String[] args) {
        System.out.println(format("1686292124289"));
    }
}
