package com.example.mybatisdemo.aop.order;

import lombok.Data;

/**
 * @author chenyile
 * @date 2022/12/5  22:43
 * @description:
 */
@Data
public class OperateLogDO {
    private Long orderId;

    private String desc;

    private String result;
}
