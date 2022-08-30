package com.example.mybatisdemo.service.impl;

import com.example.mybatisdemo.entity.Country;
import com.example.mybatisdemo.mapper.CountryMapper;
import com.example.mybatisdemo.service.CountryService;
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
public class CountryServiceImpl extends ServiceImpl<CountryMapper, Country> implements CountryService {

}
