package com.su.stu.unit14;

/**
 * @Author: supengfei
 * @Date: 2019/7/27 21:50
 * @Description:
 */
public final class Singleton03 {

    private static Singleton03 instance = null;

    private Singleton03(){}

    private synchronized static Singleton03 getInstance() {
        if (null == instance) {
            return new Singleton03();
        }
        return instance;
    }
}
