package com.su.stu.unit2;

import java.util.stream.IntStream;

/**
 * @Author: supengfei
 * @Date: 2019/3/7 20:15
 * @Description:
 */
public class ThreadName {

    public static void main(String[] args) {
        IntStream.range(0,5).boxed().map(i -> new Thread(
                () ->System.out.println(Thread.currentThread().getName()))
        ).forEach(Thread::start);
    }
}
