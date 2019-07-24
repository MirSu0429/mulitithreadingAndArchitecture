package com.su.stu.unit8;

/**
 * @Author: supengfei
 * @Date: 2019/7/21 16:28
 * @Description:
 */
public interface RunnableQueue {
    void offer(Runnable runnable);

    Runnable take() throws InterruptedException;

    int size();
}
