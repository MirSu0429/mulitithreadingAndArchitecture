package com.su.stu.unit8;

/**
 * @Author: supengfei
 * @Date: 2019/7/21 16:25
 * @Description:
 */
public interface ThreadPool {
    void execute(Runnable runnable);

    void shutdown();

    int getInitSize();

    int getMaxSize();

    int getCoreSize();

    int getQueueSize();

    int getActiveCount();

    boolean isShutdown();
}
