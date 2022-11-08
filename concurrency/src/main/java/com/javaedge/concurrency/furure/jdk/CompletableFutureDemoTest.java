package com.javaedge.concurrency.furure.jdk;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author JavaEdge
 * @date 2021/4/15
 */
@Slf4j
public class CompletableFutureDemoTest {
    public static void main(String[] args) {
        log.info("程序开始运行。。。");
        //CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
        //    try {
        //        Thread.sleep(3000);
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //    return "hello";
        //}).thenCombine(CompletableFuture.supplyAsync(() -> {
        //    try {
        //        Thread.sleep(2000);
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //    return "world";
        //}), (a, b) -> a + b);
        //try {
        //    log.info("结果为：{}", completableFuture.get());
        //} catch (InterruptedException | ExecutionException e) {
        //    e.printStackTrace();
        //}

        String result = CompletableFuture.supplyAsync(()->{return "Hello ";})
                .thenApplyAsync(v -> v + "world").join();
        System.out.println(result);
    }
}
