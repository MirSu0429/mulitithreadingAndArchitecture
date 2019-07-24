package com.su.stu.unit10;

/**
 * @Author: supengfei
 * @Date: 2019/7/24 20:46
 * @Description:
 */
public class ExtClassLoader {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.ext.dirs").replaceAll(";",";\n"));
    }
}
