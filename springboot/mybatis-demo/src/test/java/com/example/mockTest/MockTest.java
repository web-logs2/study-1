package com.example.mockTest;

import com.example.mybatisdemo.entity.City;
import com.example.mybatisdemo.service.CityService;
import com.example.mybatisdemo.service.impl.CityServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

import static org.mockito.Mockito.*;

/**
 * @author 乐乡
 * @since 2023/6/11  21:38
 * Mock注入实现原理：使用Stub(桩)技术动态的替换原程序的功能
 * 直接运行Java代码，不需要启动Spring和连接数据库，模拟一切操作数据的步骤，不执行任何SQL，也可以模拟任何返回值
 * Mockito默认不支持静态方法，可以使用PowerMock让Mockito支持静态方法（新增依赖）
 */
@RunWith(MockitoJUnitRunner.class)
public class MockTest {
    @Before
    public void before() {
        //可以用@RunWith(MockitoJUnitRunner.class)替代
        //MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() {
        Random mockRandom = Mockito.mock(Random.class);
        Assert.assertEquals(0, mockRandom.nextInt());
        //进行打桩操作，指定调用nextInt方法的返回值
        when(mockRandom.nextInt()).thenReturn(100);
        Assert.assertEquals(100, mockRandom.nextInt());
    }

    @Mock
    private Random random;

    @Test
    public void mockTest() {
        when(random.nextInt()).thenReturn(3);
        System.out.println(random.nextInt());
    }

    @Mock
    private CityService cityServiceMock;

    @Spy
    private CityService cityServiceSpy;


    /**
     * spy的对象会走真实的方法，mock对象不会
     * spy方法的参数是对象实例，mock的参数是class
     */
    @Test
    public void testMockAndSpy() {
        City city = new City();
        city.setId(1).setName("aa");
        City targetCity = new City();
        targetCity.setId(1).setName("shanghai");
        List<City> list = new ArrayList<>();
        list.add(targetCity);
        when(cityServiceMock.queryCityById(city.getId())).thenReturn(list);
    }

    /**
     * thenThrow 用来让函数调用抛出异常（可搭配try catch使用）
     * thenThrow 中可以指定多个异常，在调用时异常依次出现。若调用次数超过异常的数量，再次调用会抛最后一个异常
     */
    @Test
    public void exceptionTest() {
        when(random.nextInt()).thenThrow(new RuntimeException("异常1"), new IllegalArgumentException("异常2"));
        try {
            System.out.println(random.nextInt());
            //由于上一行会抛异常，assert.fail()不会执行
            Assert.fail();
        } catch (Exception e) {
            Assert.assertEquals("异常1", e.getMessage());
        }
        //reset 重置之前自定义的返回值和异常
        reset(random);
        try {
            System.out.println(random.nextInt());
        } catch (Exception e) {
            Assert.assertEquals("异常2", e.getMessage());
        }
    }

    /**
     * verify可以校验mock对象是否发生过某些操作，配合time方法，可以校验某些操作发生的次数
     */
    @Test
    public void verifyTest() {
        when(random.nextInt()).thenReturn(1);
        random.nextInt();
        //判断nextInt是否被调用了一次
        verify(random, times(1)).nextInt();
    }

}
