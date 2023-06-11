package com.example.mockTest;

import com.example.mybatisdemo.MybatisDemoApplication;
import com.example.mybatisdemo.entity.City;
import com.example.mybatisdemo.service.CityService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 乐乡
 * @since 2023/6/5  23:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisDemoApplication.class)
public class SpringTest {
    @Test
    public void testEquals() {
        int a = 1;
        Assert.assertEquals(1, a);
        Assertions.assertEquals(1, a);
    }

    /**
     * 使用@Autowired注入的对象，会实际操作数据库对象
     * 解决方法:可以通过可以加个@Transactional,让事务自动回滚，在多线程的情况下可能会失效，该方法并不推荐
     */
    @Autowired
    CityService cityService;

    @Transactional
    @Rollback(true)
    @Test
    public void updateCityTest() {
        City city=new City();
        city.setId(1).setName("beijing");
        List<City> cityList = cityService.queryCityById(city.getId());
        Assert.assertNotNull(cityList);
        Assert.assertNotNull(cityList.get(0));
        Assert.assertEquals(1, cityService.updateCity(city));
        Assert.assertEquals(city.getName(), cityService.queryCityById(city.getId()).get(0).getName());
    }
}
