package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.entity.City;
import com.example.mybatisdemo.mapper.CityMapper;
import com.example.mybatisdemo.service.CityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisdemo.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author chenyile
 * @since 2022-08-30
 */
@Slf4j
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {

    @Resource
    AsyncService asyncService;

    @Override
    public void exec() {
        log.info("开始执行exec方法");
        CompletableFuture<String> completableFuture = asyncService.asyncMethod3();
        CompletableFuture<Integer> newFuture = completableFuture.thenApplyAsync((res) -> res.length());
        log.info("{}", newFuture.join());
        //this.asyncMethod();
        log.info("执行exec方法结束");
    }

    //测试同类调用async方法
    //@Async("asyncServiceExecutor")
    @Override
    public void asyncMethod() {
        log.info("开始执行async方法...");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
