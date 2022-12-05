package com.example.mybatisdemo;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.*;

/**
 * 1、Future设计的初衷是对将来的某个时间的结果进行建模
 * 缺点：1）原生Future没有异步回调机制，其他任务需要主动去获取耗时的任务
 * 2）原生Future很难直接表述多个Future结果之间的依赖性
 */
@Slf4j
public class TestCompleteFuture {

    public void sleep(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printTimeAndThread(String tag) {
        String result = new StringJoiner("\t|\t")
                .add(String.valueOf(System.currentTimeMillis()))
                .add(String.valueOf(Thread.currentThread().getId()))
                .add(Thread.currentThread().getName())
                .add(tag)
                .toString();
        log.info("{}", result);
    }

    @Test
    public void test() {
        log.info("main线程启动");
        //ExecutorService executor = Executors.newCachedThreadPool();
        //Future<String> future = executor.submit(() -> {
        //    sleep(2);
        //    return "hello";
        //});
        //
        //try {
        //    String s = future.get();
        //    log.info("s:{}",s);
        //} catch (InterruptedException | ExecutionException e) {
        //    e.printStackTrace();
        //}
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            sleep(1);
            return "Hello";
        });
        try {
            log.info("{}", future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            sleep(1);
            printTimeAndThread("任务1");
            return "Hello";
        });

        future.whenComplete((s, throwable) -> {
            printTimeAndThread("任务2");
            log.info("当任务1完成时，任务2输出结果:{}", s);
        });
        printTimeAndThread("任务3");
        log.info("主线程在做其他事。。。");
    }

    /**
     * 任务二依赖于任务一的结果
     */
    @Test
    public void test3() {
        ExecutorService executorService = Executors.newCachedThreadPool((r) -> {
            Thread thread = new Thread(r);
            thread.setName("executor-1");
            return thread;
        });
        ExecutorService executorService2 = Executors.newCachedThreadPool((r) -> {
            Thread thread = new Thread(r);
            thread.setName("executor-2");
            return thread;
        });
        log.info("main线程启动");
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            printTimeAndThread("任务一");
            return "hello";
        }).thenCompose(s -> {
            printTimeAndThread("任务二");
            return CompletableFuture.supplyAsync(() -> s + "world");
        });
        log.info("{}", completableFuture.join());
    }

    @Test
    public void test4() {
        log.info("启动main线程");
        CompletableFuture<Character> future = CompletableFuture.supplyAsync(() -> {
            sleep(1);
            return "hello";
        }).thenCombine(
                CompletableFuture.supplyAsync(() -> {
                    sleep(1);
                    return 1;
                }), (a, b) -> {
                    return a.charAt(1);
                }
        );
        log.info("{}", future.join());
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test5() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            sleep(2);
            return "hello";
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            sleep(1);
            return "world";
        }), res -> res);
        System.out.println(completableFuture.join());
    }

    @Test
    public void test6() {
        log.info("main线程启动");
        List<CompletableFuture<String>> list = new ArrayList<>();
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            sleep(3);
            return "a";
        });
        list.add(future1);
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            sleep(5);
            return "b";
        });
        list.add(future2);
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            return "c";
        });
        list.add(future3);
        CompletableFuture.allOf(list.toArray(new CompletableFuture[0])).join();
        List<String> result = new ArrayList<>();
        list.forEach(future -> {
            result.add(future.join());
        });
        result.forEach(System.out::println);
        log.info("main线程结束");

    }
}
