package com.su.stu.unit10;

/**
 * @Author: supengfei
 * @Date: 2019/7/24 20:50
 * @Description:
 */
public class ApplicationClassLoader {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path").replaceAll(";",";\n"));
        System.out.println(ApplicationClassLoader.class.getClassLoader());
    }
}
