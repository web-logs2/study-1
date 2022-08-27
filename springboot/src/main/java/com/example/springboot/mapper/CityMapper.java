package com.example.springboot.mapper;

import com.example.springboot.entity.City;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author chenyile
 * @date 2022/8/27  23:13
 * @description:
 */
@Mapper
public interface CityMapper {
    List<City> queryCityList();
}
