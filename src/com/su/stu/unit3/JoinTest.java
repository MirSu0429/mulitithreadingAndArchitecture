package com.su.stu.unit3;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author: supengfei
 * @Date: 2019/3/21 20:22
 * @Description:
 */
public class JoinTest {

    public static Thread create(int i){
        return new Thread(()->
            IntStream.range(0,10).mapToObj(e -> (Thread.currentThread().getName()+"--" + e)).forEach(JoinTest::shortSleep)
        );
    }
    public static void shortSleep(String s){
        try {
            System.out.println(s);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        List<Thread> threads = IntStream.range(0, 3).mapToObj(JoinTest::create).collect(Collectors.toList());

        threads.forEach(Thread::start);

       /* for (Thread thread : threads) {
            thread.join();
        }*/

        IntStream.range(0, 10).mapToObj(e -> e+"").forEach(JoinTest::shortSleep);
        //TimeUnit.SECONDS.sleep(11);
        threads.get(0).join();
        System.out.println(1111);
    }
}
