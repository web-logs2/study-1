package com.example.mybatisdemo.aop.order;

/**
 * @author chenyile
 * @date 2022/12/5  23:25
 * @description:
 */
public class UpdateOrderConvert implements Convert<UpdateOrder> {

    @Override
    public OperateLogDO convert(UpdateOrder updateOrder) {
        OperateLogDO operateLogDO = new OperateLogDO();
        operateLogDO.setOrderId(updateOrder.getOrderId());
        return operateLogDO;
    }
}
