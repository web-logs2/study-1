package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.entity.City;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chenyile
 * @since 2022-08-30
 */
public interface CityMapper extends BaseMapper<City> {
    List<City> queryCityById(@Param("id") Integer id);

    int updateCity(City city);
}
