package com.example.mybatisdemo;

import com.example.mybatisdemo.config.ExecutorConfig;
import com.example.mybatisdemo.service.AsyncService;
import com.example.mybatisdemo.service.impl.CityServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.*;

@Slf4j
@SpringBootTest
class MybatisDemoApplicationTests {
    @Resource
    ExecutorConfig executorConfig;
    @Resource
    CityServiceImpl cityService;
    @Resource
    AsyncService asyncService;

    @Test
    void contextLoads() {
        //simpleAsyncTaskExecutor
        //Executor asyncServiceExecutor = SpringbootUtils.getBean("asyncServiceExecutor", Executor.class);
        //System.out.println(asyncServiceExecutor);
        cityService.exec();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        Future<String> stringFuture = asyncService.asyncMethod2();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("主线程在做其他的事情。。。");
        try {
            log.info("获取结果s的值为:{}",stringFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
