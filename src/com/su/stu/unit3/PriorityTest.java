package com.su.stu.unit3;

import java.util.concurrent.TimeUnit;

/**
 * @Author: supengfei
 * @Date: 2019/3/21 20:05
 * @Description:
 */
public class PriorityTest {
    public static void main(String[] args) {
        testP();
        test();
        test2();
    }

    private static void testP(){
        Thread t1 = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1");
            }
        });
        t1.setPriority(3);
        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t2");
            }
        });
        t2.setPriority(10);
        t1.setDaemon(true);
        t2.setDaemon(true);
        t1.start();
        t2.start();
    }
    private static void test() {
        ThreadGroup threadGroup = new ThreadGroup("test");
        threadGroup.setMaxPriority(7);
        Thread thread = new Thread(threadGroup, "n");
        thread.setPriority(10);
        System.out.println(thread.getPriority());
    }

    private static void test2() {
        Thread t1 = new Thread();
        System.out.println("t1 优先级是:" + t1.getPriority());
        System.out.println("当前线程id是:" + t1.currentThread().getId());
        Thread t2 = new Thread(() -> {
            Thread t3 = new Thread();
            System.out.println("t3 优先级是:" + t3.getPriority());
            System.out.println("当前线程id是:" + t3.currentThread().getId());
        });

        t2.setPriority(7);
        t2.start();
        System.out.println("t2 优先级是:" + t2.getPriority());
        System.out.println("当前线程id是:" + t2.currentThread().getId());

    }
}
