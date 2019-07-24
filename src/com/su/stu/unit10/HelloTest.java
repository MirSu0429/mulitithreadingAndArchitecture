package com.su.stu.unit10;

/**
 * @Author: supengfei
 * @Date: 2019/7/24 21:13
 * @Description:
 */
public class HelloTest {
    static {
        System.out.println("Hello 将要被初始化");
    }
    public String hello( ){
        return "你大爷";
    }

    @Override
    public String toString() {
        return "HelloTest{}";
    }
}
