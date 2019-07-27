package com.su.stu.unit14;

/**
 * @Author: supengfei
 * @Date: 2019/7/27 22:05
 * @Description:
 */
public enum Singleton07 {
    INSTANCE;

    Singleton07(){
        System.out.println("将要被实例");

    }

    public static void method(){}

    public static Singleton07 getInstance() {
        return INSTANCE;
    }
}
