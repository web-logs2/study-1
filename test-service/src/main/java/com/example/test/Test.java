package com.example.test;

import lombok.extern.slf4j.Slf4j;


/**
 * @author chenyile
 * @date 2023/2/22  12:35
 */
@Slf4j(topic = "test")
public class Test {
    public static void main(String[] args) {
        Object o1 = null;
        System.out.println(check(o1));
        System.out.println(check2(o1));
    }

    public static boolean check(Object o) {
        return o instanceof Double;
    }
    public static boolean check2(Object o) {
        return o instanceof Double && !Double.isNaN((Double) o);
    }
}
