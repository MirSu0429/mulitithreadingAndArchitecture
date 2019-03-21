package com.su.stu.unit3;

import java.util.concurrent.TimeUnit;

/**
 * @Author: supengfei
 * @Date: 2019/3/21 21:39
 * @Description:
 */
public class ShutDownThread {

    public static void main(String[] args) throws InterruptedException {
        shutDown1();
        shutDown2();
    }
    /**
     * @Description //TODO 关闭线程方式1
     * @Param
     * @return
     **/
    private static void shutDown1() throws InterruptedException {
        Thread thread = new Thread(){
        @Override
        public void run() {
            test2(this);
        }
    };
    thread.start();
    TimeUnit.SECONDS.sleep(2);
    System.out.println("线程要呗关闭了");
    thread.interrupt();
}
/**
 * @Description //TODO 关闭线程方式2
 * @Param
 * @return
 **/
    private static void shutDown2() throws InterruptedException {
        Thread thread = createThread();
        thread.start();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("要结束了");
        close(thread);
    }
    private static void test1(Thread thread){
        System.out.println("线程启动");
        while (!thread.isInterrupted()) {
        }

        System.out.println("我要结束了");
    }
    private static void test2(Thread thread){
        System.out.println("线程启动");
        for (; ; ) {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                break;
            }
        }
        System.out.println("我要结束了");
    }

    private volatile static boolean closed = false;
    private static Thread createThread(){
        return new Thread(){
            @Override
            public void run() {
                System.out.println("线程启动");
                while (!closed && !isInterrupted()) {

                }
                System.out.println("我要结束了");
            }
        };
    }

    private static void close(Thread thread){
        closed = true;
        thread.interrupt();
    }


}
