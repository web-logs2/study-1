package com.example.test;

import lombok.extern.slf4j.Slf4j;


/**
 * @author chenyile
 * @date 2023/2/22  12:35
 */
@Slf4j(topic = "test")
public class Test {
    public static void main(String[] args) {
        Object o1 = -1.1;
        System.out.println(parseDouble(o1));
    }

    public static Double parseDouble(Object o1) {
        double result;
        try {
            String s = (String) o1;
            result = Double.parseDouble(s);
        } catch (Exception e) {
            result =-99;
        }
        return result;
    }

    public static boolean check(Object o) {
        return o instanceof Double;
    }

    public static boolean check2(Object o) {
        return o instanceof Double && !Double.isNaN((Double) o);
    }
}
