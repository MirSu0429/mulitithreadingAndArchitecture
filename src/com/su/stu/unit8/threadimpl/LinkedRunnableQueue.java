package com.su.stu.unit8.threadimpl;

import com.su.stu.unit8.DenyPolicy;
import com.su.stu.unit8.RunnableQueue;
import com.su.stu.unit8.ThreadPool;

import java.util.LinkedList;

/**
 * @Author: supengfei
 * @Date: 2019/7/21 16:47
 * @Description:
 */
public class LinkedRunnableQueue implements RunnableQueue {
    private final int limit;

    private final DenyPolicy denyPolicy;

    private final ThreadPool threadPool;

    private final LinkedList<Runnable> runnableList = new LinkedList<>();

    public LinkedRunnableQueue(int limit, DenyPolicy denyPolicy, ThreadPool threadPool) {
        this.limit = limit;
        this.denyPolicy = denyPolicy;
        this.threadPool = threadPool;
    }

    @Override
    public void offer(Runnable runnable) {
        synchronized (runnableList) {
            if (runnableList.size() >= limit) {
                denyPolicy.reject(runnable, threadPool);
            } else {
                runnableList.addLast(runnable);
                runnableList.notifyAll();
            }
        }
    }

    @Override
    public Runnable take() throws InterruptedException {
        synchronized (runnableList) {
            while (runnableList.isEmpty()) {
                try {
                    runnableList.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            return runnableList.removeFirst();
        }
    }

    @Override
    public int size() {
        synchronized (runnableList) {
            return runnableList.size();
        }
    }
}
