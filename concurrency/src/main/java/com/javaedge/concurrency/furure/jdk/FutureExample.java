package com.javaedge.concurrency.furure.jdk;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author JavaEdge
 */
@Slf4j
public class FutureExample {

    static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            log.info("do something in callable");
            Thread.sleep(5000);
            return "Done";
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(new MyRunnable(), executorService);
        log.info("do something in main");
        Thread.sleep(1000);
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello");
    }
}
