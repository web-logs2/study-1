package com.example.springboot.service.impl;

import com.example.springboot.entity.City;
import com.example.springboot.mapper.CityMapper;
import com.example.springboot.service.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenyile
 * @date 2022/8/27  23:21
 * @description:
 */
@Service
public class CityServiceImpl implements CityService {
    @Resource
    CityMapper cityMapper;

    @Override
    public List<City> queryCityList() {
        return cityMapper.queryCityList();
    }
}
