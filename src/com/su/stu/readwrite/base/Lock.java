package com.su.stu.readwrite.base;

/**
 * @Author: supengfei
 * @Date: 2019/8/17 17:41
 * @Description:
 */
public interface Lock {
    //获取显式锁 没有获得的线程 进入阻塞
    void lock() throws InterruptedException;

    //释放获取的锁
    void unlock();
}
