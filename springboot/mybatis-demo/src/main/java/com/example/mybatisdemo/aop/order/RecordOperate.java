package com.example.mybatisdemo.aop.order;

import java.lang.annotation.*;

/**
 * @author chenyile
 * @date 2022/12/5  22:44
 * @description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RecordOperate {
    String desc() default "";

    Class<? extends Convert> convert();
}
