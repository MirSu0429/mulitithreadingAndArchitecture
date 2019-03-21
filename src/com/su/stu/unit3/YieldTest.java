package com.su.stu.unit3;

import java.util.stream.IntStream;

/**
 * @Author: supengfei
 * @Date: 2019/3/21 19:44
 * @Description:
 */
public class YieldTest {
    public static void main(String[] args) {
        //IntStream.of(1, 2, 3, 4, 5, 6, 7).map(elem -> elem * 10).forEach(System.out::println);

        IntStream.range(0,10).mapToObj(YieldTest::create)
                 .forEach(Thread::start);
    }

    private static Thread create(int index) {
        return new Thread(() -> {

            if (index == 5) {
                Thread.yield();
            }
            System.out.println(index);

        });
    }
}
