package com.su.stu.unit5.bolleanlock;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @Author: supengfei
 * @Date: 2019/4/5 15:14
 * @Description:
 */
public interface Lock {
    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException, TimeoutException;

    void unlock();

    List<Thread> getBockedTherads();

}
