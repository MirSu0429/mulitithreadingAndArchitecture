package com.su.stu.unit8;

import com.su.stu.unit8.threadimpl.MyThreadPool;

import java.util.concurrent.TimeUnit;

/**
 * @Author: supengfei
 * @Date: 2019/7/21 17:50
 * @Description:
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        final ThreadPool threadPool = new MyThreadPool(2, 6, 4, 1000);

        for (int i = 0; i < 20; i++) {
            threadPool.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + "正在运行---" );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        for (; ; ) {
            System.out.println("activeCount--" + threadPool.getActiveCount());
            System.out.println("queueSize--" + threadPool.getQueueSize());
            System.out.println("coreSize--" + threadPool.getCoreSize());
            System.out.println("maxSize--" + threadPool.getMaxSize());
            System.out.println("-----------------------");
            TimeUnit.SECONDS.sleep(1);
//            if (threadPool.getQueueSize() == 0) {
//                threadPool.shutdown();
//            }

        }
    }
}
