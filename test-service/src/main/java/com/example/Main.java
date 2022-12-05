package com.example;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;

/**
 * @author chenyile
 * @date 2022/9/17  10:01
 * @description:
 */

public class Main {

    public static void main(String[] args) {
        System.out.println(ZoneId.getAvailableZoneIds());
        ZonedDateTime now = ZonedDateTime.now(Clock.systemUTC());
        System.out.println(ZonedDateTime.now());
        System.out.println(now);
    }


}
