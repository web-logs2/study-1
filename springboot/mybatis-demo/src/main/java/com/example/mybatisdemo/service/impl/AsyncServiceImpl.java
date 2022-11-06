package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyile
 */
@Slf4j
@Service
public class AsyncServiceImpl implements AsyncService {

    @Async("asyncServiceExecutor")
    @Override
    public void asyncMethod() {
        log.info("正在执行asyncMethod方法");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("执行asyncMethod方法结束");
    }

    @Async
    @Override
    public Future<String> asyncMethod2() {
        log.info("正在执行asyncMethod2方法");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>("hello world");
    }
}
