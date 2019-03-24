package com.su.stu.unit4;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @Author: supengfei
 * @Date: 2019/3/23 14:02
 * @Description:
 */
public class Mutex {
    private final static Object MUTEX = new Object();
    public  void test( ){
        synchronized (MUTEX) {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final Mutex mutex = new Mutex();
        for (int i = 0; i < 5; i++) {
            new Thread(mutex::test).start();
        }
    }
}
