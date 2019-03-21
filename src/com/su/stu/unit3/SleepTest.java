package com.su.stu.unit3;

import java.util.concurrent.TimeUnit;

/**
 * @Author: supengfei
 * @Date: 2019/3/21 19:37
 * @Description:
 */
public class SleepTest {
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                long startTime = System.currentTimeMillis();
                TimeUnit.SECONDS.sleep(2);
                long endTime = System.currentTimeMillis();
                System.out.println("休眠时间为:"+ (endTime - startTime));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        long startTime = System.currentTimeMillis();
        Thread.sleep(3000);
        long endTime = System.currentTimeMillis();
        System.out.println("休眠时间为:"+ (endTime - startTime));
    }
}
