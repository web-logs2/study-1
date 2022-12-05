package com.example.mybatisdemo.aop.order;

/**
 * @author chenyile
 * @date 2022/12/5  23:24
 * @description:
 */
public class SaveOrderConvert implements Convert<SaverOrder> {

    @Override
    public OperateLogDO convert(SaverOrder saverOrder) {
        OperateLogDO operateLogDO = new OperateLogDO();
        operateLogDO.setOrderId(saverOrder.getId());
        return operateLogDO;
    }
}
