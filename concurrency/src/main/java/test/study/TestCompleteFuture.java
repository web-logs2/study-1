package test.study;

import com.javaedge.concurrency.common.LogUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyile
 * @date 2022/11/7  20:59
 * @description:
 */
public class TestCompleteFuture {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<CompletableFuture<?>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final int I = i;
            CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return I;
            });
            futureList.add(integerCompletableFuture);
        }
        //CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).join();
        for (CompletableFuture<?> completableFuture : futureList) {
            System.out.println(completableFuture.join());
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
