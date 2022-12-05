package com.example.mybatisdemo.controller;


import com.example.mybatisdemo.entity.City;
import com.example.mybatisdemo.service.CityService;
import com.example.mybatisdemo.util.RequestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author chenyile
 * @since 2022-08-30
 */
@RestController
@RequestMapping("/city")
public class CityController {
    @Resource
    CityService cityService;

    @PostMapping("test")
    public List<City> test() {
        return cityService.list();
    }

    @PostMapping("param/get")
    public String getParam() {
       return RequestUtils.getParameter("name");
    }

}

