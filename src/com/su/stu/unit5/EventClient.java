package com.su.stu.unit5;

import java.util.concurrent.TimeUnit;

/**
 * @Author: supengfei
 * @Date: 2019/4/4 21:28
 * @Description:
 */
public class EventClient {
    public static void main(String[] args) {
        final EventQueue eventQueue = new EventQueue();
        new Thread(() -> {
            for (; ; ) {
                eventQueue.offer(new EventQueue.Event());
            }
        }, "生产者").start();
        new Thread(() -> {
            for (; ; ) {
                eventQueue.take();
               /* try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }, "消费者").start();

    }
}
