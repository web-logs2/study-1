package com.example.springboot.controller;

import com.example.springboot.entity.City;
import com.example.springboot.service.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenyile
 * @date 2022/8/27  23:26
 * @description:
 */
@RestController
public class CityController {
    @Resource
    CityService cityService;

    @GetMapping("test")
    public void test() {
        List<City> cities = cityService.queryCityList();
        System.out.println(cities);
    }
}
