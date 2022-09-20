package com.javaedge.concurrency.furure.jdk;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

/**
 * @author JavaEdge
 * @date 2021/4/15
 */
@Slf4j
public class CompletableFutureDemoTest {
    public static void main(String[] args) {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        }).thenCompose((s) -> CompletableFuture.supplyAsync(() -> s + s));
        System.out.println(String.format("%s 世界", completableFuture.join()));
    }
}
