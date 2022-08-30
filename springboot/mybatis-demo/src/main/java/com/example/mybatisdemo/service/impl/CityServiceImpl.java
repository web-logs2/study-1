package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.entity.City;
import com.example.mybatisdemo.mapper.CityMapper;
import com.example.mybatisdemo.service.CityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenyile
 * @since 2022-08-30
 */
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {

}
