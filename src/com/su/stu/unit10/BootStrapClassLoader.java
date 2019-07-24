package com.su.stu.unit10;

/**
 * @Author: supengfei
 * @Date: 2019/7/24 20:43
 * @Description:
 */
public class BootStrapClassLoader {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(System.getProperty("sun.boot.class.path").replaceAll(";",";\n"));
    }
}
