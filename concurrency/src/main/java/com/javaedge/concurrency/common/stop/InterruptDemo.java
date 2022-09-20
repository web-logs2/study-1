package com.javaedge.concurrency.common.stop;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author chenyile
 * @date 2022/9/14  22:08
 * @description:
 */
public class InterruptDemo {
    static AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public static void main(String[] args) {
        m1();
    }

    public static void m1() {
        new Thread(() -> {
            while (true) {
                if (atomicBoolean.get()) {
                    System.out.println("程序运行结束。。。");
                    break;
                }
                System.out.println("程序运行中。。。");
            }
        }).start();
        //暂停1秒钟线程
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            atomicBoolean.set(true);
        }, "t2").start();
    }
}
