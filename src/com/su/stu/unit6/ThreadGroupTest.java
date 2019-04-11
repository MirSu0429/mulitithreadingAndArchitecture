package com.su.stu.unit6;

import java.util.concurrent.TimeUnit;

/**
 * @author MirSu
 * @version V1.0
 * @Package com.su.stu.unit6
 * @Email 1023012015@qq.com
 * @date 2019/4/11 14:28
 * @Description:
 */
public class ThreadGroupTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup threadGroup = new ThreadGroup("myGroup1");
        Thread thread = new Thread(threadGroup, () ->{
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();

        TimeUnit.MICROSECONDS.sleep(1);

        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        System.out.println("activeCount=" + mainGroup.activeCount());
        System.out.println("activeGroupCount=" + mainGroup.activeGroupCount());
        System.out.println("threadGroup=" + threadGroup.getMaxPriority());
        System.out.println("thread=" + thread.getPriority());
        System.out.println("getName=" + mainGroup.getName());
        System.out.println("getParent=" + mainGroup.getParent());
        mainGroup.list();
        System.out.println("threadGroup=" + mainGroup.parentOf(threadGroup));
        System.out.println("mainGroup=" + mainGroup.parentOf(mainGroup));
        threadGroup.setMaxPriority(3);
        System.out.println("threadGroup=" + threadGroup.getMaxPriority());
        System.out.println("thread=" + thread.getPriority());
    }
}
