package com.su.stu.unit5.bolleanlock;

import java.util.*;
import java.util.concurrent.TimeoutException;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.currentThread;

/**
 * @Author: supengfei
 * @Date: 2019/4/5 15:18
 * @Description:
 */
public class BooleanLock implements Lock {
    private Thread currentThread;
    private boolean locked = false;
    private final List<Thread> blockList = new ArrayList<>();

    @Override
    public void lock() throws InterruptedException {
        synchronized (this) {
            while (locked) {
                final Thread tempThread = currentThread();
                try {
                    if (!blockList.contains(currentThread()))
                        blockList.add(currentThread());
                    this.wait();
                } catch (InterruptedException e) {
                    blockList.remove(tempThread);
                    throw e;
                }
            }
            blockList.remove(currentThread());
            this.locked = true;
            this.currentThread = currentThread();
        }
    }

    @Override
    public void lock(long mills) throws TimeoutException, InterruptedException {
        synchronized (this) {
            if (mills <= 0) {
                this.lock();
            } else {
                long remainingMills = mills;
                long endMills = currentTimeMillis() + remainingMills;
                while (locked) {
                    final Thread tempThread = currentThread();
                    try {
                        if (remainingMills <= 0) {
                            throw new TimeoutException("在" + mills + "ms 内,无法获得到锁!");
                        }
                        if (!blockList.contains(currentThread())) {
                            blockList.add(currentThread());
                        }
                        this.wait(remainingMills);
                    } catch (InterruptedException e) {
                        blockList.remove(tempThread);
                        throw e;
                    }
                    remainingMills = endMills - currentTimeMillis();
                }
                blockList.remove(currentThread());
                this.locked = true;
                this.currentThread = currentThread();
            }
        }
    }

    @Override
    public void unlock() {
        synchronized (this) {
            if (currentThread == currentThread()) {
                this.locked = false;
                Optional.of(currentThread().getName() + "释放了锁").ifPresent(System.out::println);
                this.notifyAll();
            }
        }
    }

    @Override
    public List<Thread> getBockedTherads() {
        return Collections.unmodifiableList(blockList);
    }

}
