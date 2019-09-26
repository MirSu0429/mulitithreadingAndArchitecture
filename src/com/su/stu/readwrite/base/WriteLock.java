package com.su.stu.readwrite.base;

/**
 * @Author: supengfei
 * @Date: 2019/8/17 17:59
 * @Description:
 */
public class WriteLock implements Lock {
    private final ReadWriteLockImpl readWriteLock;
    public WriteLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLock.getMUTRX()) {
            //等待写的线程数 增加
            readWriteLock.incrementWaitingWriters();
            try {
                //有线程正在读
                //有线程正在写
                //都进会阻塞
                while (readWriteLock.getReadingReaders() > 0 || readWriteLock.getWritingWriters() > 0) {
                    readWriteLock.getMUTRX().wait();
                }
            }finally {
                //成功获取到了 写入锁 将等待获取写操作的线程减1
                readWriteLock.decrementWaitingWriters();
            }
            //将正在写操作的线程 加-
            readWriteLock.incrementWritingWriters();
        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getMUTRX()) {
            //减少正在写的线程数
            readWriteLock.decrementWritingWriters();
            //偏好设置为 读
            readWriteLock.setPreferWriter(false);
            //幻醒其他线程
            readWriteLock.getMUTRX().notifyAll();
        }
    }
}
