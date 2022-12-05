package com.example.mybatisdemo.aop.order;

import org.springframework.stereotype.Service;

/**
 * @author chenyile
 * @date 2022/12/5  22:27
 * @description:
 */
@Service
public class OrderService {

    @RecordOperate(desc = "保存订单", convert = SaveOrderConvert.class)
    public Boolean saveOrder(SaverOrder order) {
        System.out.println("save order ,orderId :" + order.getId());
        return true;
    }

    @RecordOperate(desc = "更新订单", convert = UpdateOrderConvert.class)
    public Boolean updateOrder(UpdateOrder order) {
        System.out.println("update order ,orderId :" + order.getOrderId());
        return true;
    }
}
