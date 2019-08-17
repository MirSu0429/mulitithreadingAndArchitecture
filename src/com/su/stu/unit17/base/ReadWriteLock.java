package com.su.stu.unit17.base;

/**
 * @Author: supengfei
 * @Date: 2019/8/17 17:43
 * @Description:
 */
public interface ReadWriteLock {

    //创建reader锁
    Lock readLock();

    //创建writer锁
    Lock writeLock();

    //获取正在执行写操做的线程数
    int getWritingWriters();

    //获取正在等待获得写入锁的线程数
    int getWaitingWriters();

    //获取等待获取读操作锁的线程数
    int getReadingReaders();

    static ReadWriteLock readWriteLock() {
        return new ReadWriteLockImpl();
    }
    static ReadWriteLock readWriteLock(boolean preferWriter) {
        return new ReadWriteLockImpl(preferWriter);
    }
}
