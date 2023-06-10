package com.example.mybatisdemo.aop.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author chenyile
 * @date 2022/12/5  22:34
 * @description:
 */
@EnableAspectJAutoProxy
@SpringBootApplication
public class OrderApplication implements CommandLineRunner {
    public static void main(String[] args) {
        new SpringApplication(OrderApplication.class).run(args);
    }

    @Autowired
    OrderService orderService;

    @Override
    public void run(String... args) throws Exception {
        //SaverOrder saverOrder = new SaverOrder();
        //saverOrder.setId(1L);
        //orderService.saveOrder(saverOrder);
        //UpdateOrder updateOrder = new UpdateOrder();
        //updateOrder.setOrderId(2L);
        //orderService.updateOrder(updateOrder);
    }
}
