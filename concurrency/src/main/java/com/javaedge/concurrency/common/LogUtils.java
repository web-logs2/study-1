package com.javaedge.concurrency.common;

import lombok.extern.slf4j.Slf4j;

import java.util.StringJoiner;

/**
 * @author chenyile
 * @date 2022/11/7  20:55
 * @description:
 */
@Slf4j
public class LogUtils {
    public static void printTimeAndThread(String tag) {
        String result = new StringJoiner("\t|\t")
                .add(String.valueOf(System.currentTimeMillis()))
                .add(String.valueOf(Thread.currentThread().getId()))
                .add(Thread.currentThread().getName())
                .add(tag)
                .toString();
        System.out.println(result);
    }

    public static void main(String[] args) {
        printTimeAndThread("主线程");
    }
}
