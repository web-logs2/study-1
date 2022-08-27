package com.example.springboot.service;

import com.example.springboot.entity.City;

import java.util.List;

/**
 * @author chenyile
 * @date 2022/8/27  23:19
 * @description:
 */
public interface CityService {
    List<City> queryCityList();
}
