package com.su.stu.readwrite.base;

/**
 * @Author: supengfei
 * @Date: 2019/8/17 18:08
 * @Description:
 */
public class ReadLock implements Lock {

    private final ReadWriteLockImpl readWriteLock;

    public ReadLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLock.getMUTRX()) {
            //有线程正在写入 无法读,挂起
            //有等待写入的线程 且 偏向于写操作 无发读  挂起
            while (readWriteLock.getWritingWriters() > 0 || (readWriteLock.getPreferWriter() && readWriteLock.getWaitingWriters() > 0)) {
                readWriteLock.getMUTRX().wait();
            }
            //成功获取读锁,将读的线程增加
            readWriteLock.incrementReadingReaders();
        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getMUTRX()) {
            //读完后 释放锁
            //1.读的线程数量减少
            //2.将偏好设为 写,优先写操作
            //3.唤醒mutex  等待列队的线程  继续抢锁
            readWriteLock.decrementReadingReaders();
            readWriteLock.setPreferWriter(true);
            readWriteLock.getMUTRX().notifyAll();
        }
    }
}
