package com.example.mybatisdemo.service;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public interface AsyncService {
    void asyncMethod();

    Future<String> asyncMethod2();

    CompletableFuture<String> asyncMethod3();
}
