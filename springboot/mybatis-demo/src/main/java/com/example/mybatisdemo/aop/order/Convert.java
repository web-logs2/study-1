package com.example.mybatisdemo.aop.order;

/**
 * @author chenyile
 * @date 2022/12/5  23:24
 * @description:
 */
public interface Convert<PARAM> {
    OperateLogDO convert(PARAM param);
}
