package com.example.mybatisdemo.service;

import com.example.mybatisdemo.entity.City;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author chenyile
 * @since 2022-08-30
 */
public interface CityService extends IService<City> {
    void exec();

    void asyncMethod();
}
