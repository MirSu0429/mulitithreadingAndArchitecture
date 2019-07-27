package com.su.stu.unit14;

/**
 * @Author: supengfei
 * @Date: 2019/7/27 21:48
 * @Description:
 */
public final class Singleton02 {

    private static Singleton02 instance = null;

    private Singleton02(){}

    public static Singleton02 getInstance() {
        if (instance == null) {
            return new Singleton02();
        }
        return instance;
    }
}
