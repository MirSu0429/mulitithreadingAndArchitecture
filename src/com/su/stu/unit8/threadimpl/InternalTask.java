package com.su.stu.unit8.threadimpl;

import com.su.stu.unit8.RunnableQueue;

/**
 * @Author: supengfei
 * @Date: 2019/7/21 16:40
 * @Description:
 */
public class InternalTask implements Runnable {
    private final RunnableQueue runnableQueue;

    private volatile boolean runing = true;
    public InternalTask(RunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }

    @Override
    public void run() {
        while (runing && !Thread.currentThread().isInterrupted()) {
            try {
                Runnable task = runnableQueue.take();
                task.run();
            } catch (InterruptedException e) {
                runing = false;
                break;
            }

        }
    }

    public void stop() {
        this.runing = false;
    }
}
