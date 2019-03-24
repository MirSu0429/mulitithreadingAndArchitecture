package com.su.stu.unit1;

import java.util.concurrent.TimeUnit;

/**
 * @Author: supengfei
 * @Date: 2019/3/7 20:06
 * @Description:
 */
public class TicketWindowRunnable  implements Runnable{
    private String name;
    private int index = 1;
    private final static int MAX = 50;
    @Override
    public void run() {
        synchronized (new Object()) {

            while (index < MAX) {
                System.out.println(Thread.currentThread() + "号码是:" + (index++));
            /*try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            }
        }
    }

    public static void main(String[] args) {
        TicketWindowRunnable t = new TicketWindowRunnable();
        new Thread(t,"1号机").start();
        new Thread(t,"2号机").start();
        new Thread(t,"3号机").start();
        new Thread(t,"4号机").start();
        new Thread(t,"5号机").start();
    }
}
