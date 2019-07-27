package com.su.stu.unit14;

/**
 * @Author: supengfei
 * @Date: 2019/7/27 21:43
 * @Description: 恶汉式
 */
public final class Singleton01 {
    private static Singleton01 instance = new Singleton01();

    private Singleton01(){}

    public static Singleton01 getInstance(){
        return instance;
    }
}