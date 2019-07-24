package com.su.stu.unit10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;

/**
 * @Author: supengfei
 * @Date: 2019/7/24 21:16
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> aClass = myClassLoader.loadClass("com.su.stu.unit10.HelloTest");
        System.out.println(aClass.getClassLoader());

        Object instance = aClass.newInstance();
        System.out.println(instance);
        Method method = aClass.getMethod("hello");
        String invoke = (String)method.invoke(instance);
        System.out.println(invoke);
    }
}
