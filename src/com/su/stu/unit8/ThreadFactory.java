package com.su.stu.unit8;

/**
 * @Author: supengfei
 * @Date: 2019/7/21 16:29
 * @Description:
 */
@FunctionalInterface
public interface ThreadFactory {

    Thread createThread(Runnable runnable);
}
