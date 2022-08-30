package com.example.mybatisdemo.config;

import org.apache.ibatis.logging.Log;

/**
 * @author chenyile
 * @date 2022/8/30  23:49
 * @description:
 */
public class SqlOutLogConfig implements Log {
    public SqlOutLogConfig(String clazz) {
        //System.out.println("SqlOutLogImpl::" + clazz);
    }

    @Override
    public boolean isDebugEnabled() {
        return true;
    }

    @Override
    public boolean isTraceEnabled() {
        return false;
    }

    @Override
    public void error(String s, Throwable throwable) {
        System.err.println(s);
        throwable.printStackTrace(System.err);
    }

    @Override
    public void error(String s) {
        System.err.println("SqlOutLogImpl:error:" + s);
    }

    @Override
    public void debug(String s) {
        System.out.println("SqlOutLogImpl:debug:" + s);
    }

    @Override
    public void trace(String s) {
        System.out.println("SqlOutLogImpl:trace:" + s);
    }

    @Override
    public void warn(String s) {
        System.out.println("SqlOutLogImpl:warn:" + s);
    }
}
